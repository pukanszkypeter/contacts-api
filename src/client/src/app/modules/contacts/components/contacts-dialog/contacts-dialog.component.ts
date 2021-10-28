import {Component, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from "@angular/forms";
import {Company} from "../../../company/models/entities/Company";
import {BlockList} from "../../../blocklist/models/entities/BlockList";
import {CompanyDataService} from "../../../company/services/company-data.service";
import {BlockListDataService} from "../../../blocklist/services/blocklist-data.service";
import {ContactsDataService} from "../../services/contacts-data.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {MatDialogRef} from "@angular/material/dialog";
import {Contact} from "../../models/entities/Contact";
import {Status} from "../../../../models/types/Status";
import {LanguageService} from "../../../../services/client-side/language.service";

@Component({
  selector: 'app-contacts-dialog',
  templateUrl: './contacts-dialog.component.html',
  styleUrls: ['./contacts-dialog.component.scss']
})
export class ContactsDialogComponent implements OnInit {

  contactsForm: FormGroup;

  companyList: Company[] = [];
  blockList: BlockList[] = [];

  tempPhoneNumberLength: number = 0;

  constructor(private fb: FormBuilder,
              private _snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<ContactsDialogComponent>,
              private companyService: CompanyDataService,
              private blockListService: BlockListDataService,
              private contactService: ContactsDataService,
              private languageService: LanguageService) {

    /** Initialize Form */
    this.contactsForm = this.fb.group({
      lastName: new FormControl('', [Validators.required, Validators.maxLength(100)]),
      firstName: new FormControl('', [Validators.required, Validators.maxLength(100)]),
      company: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z0-9]{3,}[@][a-zA-Z0-9]{3,}[.][a-z]{2,4}$'), this.blockedDomainValidator()]),
      phoneNumber: new FormControl('', [Validators.pattern('^[+]36\\s\\d{2}\\s\\d{3}\\s\\d{4}$')]),
      comment: new FormControl('', [])
    });

    /** Separates the phone number correctly with spaces.
     * Easier interface for end user. */
    this.phoneNumber.valueChanges.subscribe(res => {
      if (this.tempPhoneNumberLength < res.length && res.length === 3) {
        this.phoneNumber.setValue(res + ' ');
      } else if (this.tempPhoneNumberLength < res.length &&res.length === 6) {
        this.phoneNumber.setValue(res + ' ');
      } else if (this.tempPhoneNumberLength < res.length &&res.length === 10) {
        this.phoneNumber.setValue(res + ' ');
      }
      this.tempPhoneNumberLength = res.length;
    });

    /** Initialize Data */
    let companyPromise = this.companyService.findAll().toPromise();
    let blockListPromise = this.blockListService.findAll().toPromise();

    Promise.all([companyPromise, blockListPromise]).then(values => {
      this.companyList = values[0];
      this.blockList = values[1];
    }).catch(error => {
      console.log(error);
      this.openSnackBar(this.languageService.getTranslatedText('DOWNLOAD_DATA_ERROR'), 'error-snackbar');
      this.dialogRef.close();
    });

  }

  ngOnInit(): void {
  }

  /** Contact */
  save(): void {
    this.contactService.addContact(
      new Contact(0,
        this.lastName.value,
        this.firstName.value,
        this.email.value,
        this.phoneNumber.value,
        this.company.value,
        this.comment.value,
        Status.ACTIVE))
      .subscribe(res => {
          this.openSnackBar(this.languageService.getTranslatedText('SUCCESSFUL_SAVE'), 'success-snackbar');
          this.dialogRef.close(res);
    }, err => {
          console.log(err);
          this.openSnackBar(this.languageService.getTranslatedText('UNSUCCESSFUL_SAVE'), 'error-snackbar');
          this.dialogRef.close();
    });
  }

  /** Form Controls */

  get lastName(): FormControl {
    return this.contactsForm.get('lastName') as FormControl;
  }

  get firstName(): FormControl {
    return this.contactsForm.get('firstName') as FormControl;
  }

  get company(): FormControl {
    return this.contactsForm.get('company') as FormControl;
  }

  get email(): FormControl {
    return this.contactsForm.get('email') as FormControl;
  }

  get phoneNumber(): FormControl {
    return this.contactsForm.get('phoneNumber') as FormControl;
  }

  get comment(): FormControl {
    return this.contactsForm.get('comment') as FormControl;
  }


  /** Other Methods */

  openSnackBar(msg: string, style: string): void {
    this._snackBar.open(msg, null, {
      horizontalPosition: "center",
      verticalPosition: "top",
      duration: 2000,
      panelClass: [style]
    });
  }

  blockedDomainValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      let blockedDomain: boolean;
      for (let domain of this.blockList) {
        if (control.value.includes(domain.domain)) {
          blockedDomain = true;
        }
      }
      return blockedDomain ? {blockedDomain: {value: control.value}} : null;
    };
  }

}
