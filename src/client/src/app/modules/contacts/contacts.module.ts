import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactsPageComponent } from './components/contacts-page/contacts-page.component';
import { ContactsDialogComponent } from './components/contacts-dialog/contacts-dialog.component';
import {MatCardModule} from "@angular/material/card";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatTableModule} from "@angular/material/table";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MatDialogModule} from "@angular/material/dialog";



@NgModule({
  declarations: [
    ContactsPageComponent,
    ContactsDialogComponent
  ],
    imports: [
        CommonModule,
        MatCardModule,
        MatPaginatorModule,
        MatTableModule,
        MatButtonModule,
        MatIconModule,
        MatProgressBarModule,
        MatSnackBarModule,
        MatDialogModule
    ]
})
export class ContactsModule { }
