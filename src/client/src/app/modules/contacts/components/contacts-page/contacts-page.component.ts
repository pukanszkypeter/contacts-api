import {Component, OnInit, ViewChild} from '@angular/core';
import {ContactsDataService} from "../../services/contacts-data.service";
import {MatTableDataSource} from "@angular/material/table";
import {ContactDto} from "../../models/dto/ContactDto";
import {Page} from "../../../../models/others/Page";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatDialog} from "@angular/material/dialog";
import {ContactsDialogComponent} from "../contacts-dialog/contacts-dialog.component";
import {LanguageService} from "../../../../services/client-side/language.service";

@Component({
  selector: 'app-contacts-page',
  templateUrl: './contacts-page.component.html',
  styleUrls: ['./contacts-page.component.scss']
})
export class ContactsPageComponent implements OnInit  {

  contacts: MatTableDataSource<ContactDto>;

  page: Page;
  displayedColumns: string[] = ['number', 'name', 'company', 'email', 'phoneNumber'];

  loading: boolean;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private contactsDataService: ContactsDataService,
              private _snackBar: MatSnackBar,
              private languageService: LanguageService,
              public dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.page = new Page(0,10);
    this.refreshTable();
  }

  /** TABLE FUNCTIONS */

  refreshTable(): void {
    this.loading = true;
    Promise.all([this.downloadPage(), this.downloadSize()]).then(value => {
      this.contacts = new MatTableDataSource<ContactDto>(value[0]);
      setTimeout(() => this.contacts.paginator = this.paginator);
      setTimeout(() => this.contacts.paginator.length = value[1]);

    }).catch(error => {
      console.log(error);
      this.openSnackBar(this.languageService.getTranslatedText('DOWNLOAD_DATA_ERROR'), 'error-snackbar');

    }).finally(() => this.loading = false);
  }

  refreshPage(): void {
    this.loading = true;
    this.downloadPage().then(value => {
      this.contacts = new MatTableDataSource<ContactDto>(value);

    }).catch(error => {
      console.log(error);
      this.openSnackBar(this.languageService.getTranslatedText('DOWNLOAD_DATA_ERROR'), 'error-snackbar');

    }).finally(() => this.loading = false);
  }

  /** TABLE EVENTS */

  pageChange(event: PageEvent): void {
    if (this.page.index !== event.pageIndex) {
      this.pageIndexChange(event.pageIndex);
    } else if (this.page.offset !== event.pageSize) {
      this.pageSizeChange(event.pageSize);
    }
  }

  pageIndexChange(index: number): void {
    this.page.index = index;
    this.refreshPage();
  }

  pageSizeChange(size: number): void {
    this.page.offset = size;
    this.refreshPage();
  }

  /** DATA FUNCTIONS */

  downloadPage(): Promise<ContactDto[]> {
    return new Promise((resolve, reject) => {
      /** Not nice, but gives back the real life case */
      setTimeout(() => {
        this.contactsDataService.findAllActive(this.page).subscribe(res => resolve(res), err => reject(err));
      }, 500);
    });
  }

  downloadSize(): Promise<number> {
    return new Promise((resolve, reject) => {
      /** Not nice, but gives back the real life case */
      setTimeout(() => {
        this.contactsDataService.countAllActive().subscribe(res => resolve(res), err => reject(err));
      }, 500);
    });
  }

  /** DIALOG FUNCTIONS */

  openDialog(): void {
    const dialogRef = this.dialog.open(ContactsDialogComponent, {
      width: '40%',
      height: '80%',
      disableClose: true
    });

    dialogRef.afterClosed().subscribe(res => {
      if (res) {
        this.page.index = 0;
        this.refreshTable();
      }
    }, err => {
      this.openSnackBar(this.languageService.getTranslatedText('FORM_ERROR'), 'error-snackbar');
    });
  }

  /** OTHER FUNCTIONS */

  openSnackBar(msg: string, style: string): void {
    this._snackBar.open(msg, null, {
      horizontalPosition: "center",
      verticalPosition: "top",
      duration: 2000,
      panelClass: [style]
    });
  }

}
