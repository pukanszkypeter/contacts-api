import { Component, OnInit } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {languages} from "../../models/others/Languages";
import {MatDialogRef} from "@angular/material/dialog";
import {FormControl} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {LanguageService} from "../../services/client-side/language.service";
import {LANGUAGE_KEY} from "../../app.component";

@Component({
  selector: 'app-settings-dialog',
  templateUrl: './settings-dialog.component.html',
  styleUrls: ['./settings-dialog.component.scss']
})
export class SettingsDialogComponent implements OnInit {

  language: string;
  languageControl: FormControl;

  languages = languages;

  constructor(private translate: TranslateService,
              private languageService: LanguageService,
              private _snackBar: MatSnackBar,
              private dialogRef: MatDialogRef<SettingsDialogComponent>) {
    this.language = translate.getDefaultLang();
    this.languageControl = new FormControl(this.language, []);
  }

  ngOnInit(): void {
  }

  save(): void {
    localStorage.setItem(LANGUAGE_KEY, this.languageControl.value);
    this.translate.setDefaultLang(this.languageControl.value);
    setTimeout(() => this.openSnackBar(this.languageService.getTranslatedText('SUCCESSFUL_SAVE'), 'success-snackbar'), 500);
    this.dialogRef.close();
  }

  openSnackBar(msg: string, style: string): void {
    this._snackBar.open(msg, null, {
      horizontalPosition: "center",
      verticalPosition: "top",
      duration: 2000,
      panelClass: [style]
    });
  }

}
