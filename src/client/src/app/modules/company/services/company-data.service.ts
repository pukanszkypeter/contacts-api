import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ServerRoutes} from "../../../models/others/ServerRoutes";
import {map} from "rxjs/operators";
import {Company} from "../models/entities/Company";
import {CompanyServerRoutes} from "../CompanyServerRoutes";

@Injectable({
  providedIn: 'root'
})
export class CompanyDataService {

  constructor(private http: HttpClient) { }

  /** QUERY */
  public findAll(): Observable<Company[]> {
    return this.http.get<Company[]>(ServerRoutes.API_ROUTE + CompanyServerRoutes.FIND_ALL)
      .pipe(
        map(res => res.map(company => new Company().initialize(company)))
      )
  }

}
