import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ServerRoutes} from "../../../models/others/ServerRoutes";
import {map} from "rxjs/operators";
import {BlockList} from "../models/entities/BlockList";
import {BlockListServerRoutes} from "../BlockListServerRoutes";

@Injectable({
  providedIn: 'root'
})
export class BlockListDataService {

  constructor(private http: HttpClient) { }

  /** QUERY */
  public findAll(): Observable<BlockList[]> {
    return this.http.get<BlockList[]>(ServerRoutes.API_ROUTE + BlockListServerRoutes.FIND_ALL)
      .pipe(
        map(res => res.map(domain => new BlockList().initialize(domain)))
      )
  }

}
