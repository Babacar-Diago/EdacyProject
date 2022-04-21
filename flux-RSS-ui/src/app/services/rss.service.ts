import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "../../environments/environment";
import {Items} from "../models/items";

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

  editItem(item:Items, title:string, description:string){
    return this.httpClient.put(this.host+'/edititem', item);
  }

}
