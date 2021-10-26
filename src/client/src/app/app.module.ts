import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LayoutComponent} from './components/layout/layout.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {MatCardModule} from "@angular/material/card";
import {HttpClientModule} from "@angular/common/http";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import {ContactsModule} from "./modules/contacts/contacts.module";

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    DashboardComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    ContactsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
