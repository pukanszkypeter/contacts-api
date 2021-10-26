import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ContactDto} from "../models/dto/ContactDto";
import {Page} from "../../../models/others/Page";
import {ContactsServerRoutes} from "../ContactsServerRoutes";
import {map} from "rxjs/operators";
import {Contact} from "../models/entities/Contact";
import {ServerRoutes} from "../../../models/others/ServerRoutes";

@Injectable({
  providedIn: 'root'
})
export class ContactsDataService {

  constructor(private http: HttpClient) { }

  /** QUERY */
  public findAllActive(page: Page): Observable<ContactDto[]> {
    return this.http.post<ContactDto[]>(ServerRoutes.API_ROUTE + ContactsServerRoutes.FIND_ALL_ACTIVE, page)
      .pipe(
        map(res => res.map(contact => new ContactDto().initialize(contact)))
      )
  }

  public countAllActive(): Observable<number> {
    return this.http.get<number>(ServerRoutes.API_ROUTE + ContactsServerRoutes.COUNT_ALL_ACTIVE);
  }

  /** MANIPULATION */
  public addContact(contact: Contact): Observable<Contact> {
    return this.http.post<Contact>(ServerRoutes.API_ROUTE + ContactsServerRoutes.ADD_CONTACT, contact)
      .pipe(
        map(contact => new Contact().initialize(contact))
      );
  }

}
