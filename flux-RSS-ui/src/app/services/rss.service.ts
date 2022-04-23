import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import {Items} from "../models/items";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RssService {

  private host = environment.host;

  constructor(private httpClient: HttpClient) { }

  // Methode qui permet de récupérer le flux rss
  getFlux() {
    return this.httpClient.get(this.host + '/rss');
  }

  // Methode qui permet de récupérer le flux rss
  getFluxSaved() {
    return this.httpClient.get(this.host + '/rss/all');
  }

  getItem(id: number): Observable<Items> {
    // @ts-ignore
    return this.httpClient.get(this.host + '/item/'+id);
  }

  // mise a jour d'un produit
  updateItem(item: Items): Observable<Items>{
    return this.httpClient.patch<Items>(this.host+"/edititem", item);
  }
}
