import { Component, OnInit } from '@angular/core';
import {RssService} from "../services/rss.service";
import {Router} from "@angular/router";
import {Items} from "../models/items";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  flux: any;
  items: any;
  item: Object | undefined;
  title: string | undefined;

  ngOnInit(): void {
    this.onFluxRss();
  }

  constructor(private rssService: RssService, private router: Router) {
  }

  onFluxRss(){
    this.rssService.getFluxSaved()
      .subscribe(data=>{
        this.flux = data;
        this.items = this.flux.items;
        console.log(this.items);
      },err=>{
        console.log(err);
      });
  }

  onEdit(item: Items) {
    this.router.navigateByUrl("/edititem/"+item.id);
  }

}
