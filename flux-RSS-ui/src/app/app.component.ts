import { Component } from '@angular/core';
import {RssService} from "./services/rss.service";
import {Items} from "./models/items";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  flux: any;
  items: any;
  item: Object | undefined;
  title: string | undefined;
  pageOfItems: Array<any> | undefined;

  constructor(private rssService: RssService, private router: Router) {}

  ngOnInit(): void {
    this.onFluxRss();
  }

  onFluxRss(){
    this.rssService.getFlux()
      .subscribe(data=>{
        this.flux = data;
        this.items = this.flux.items;
        //console.log(this.items);
      },err=>{
        console.log(err);
      });
  }

  // editTitle(item: Items, title:string) {
  //   this.rssService.editTitle(item, item.title)
  //     .subscribe(response =>{
  //       this.item=response;
  //     }, err=>{
  //       console.log(err);
  //     });
  // }
  //
  // onEdit(item: Items) {
  //   this.router.navigateByUrl("/edititem/"+item.id);
  // }

}
