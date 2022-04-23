import { Component, OnInit } from '@angular/core';
import {RssService} from "../services/rss.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-flux-rss-stream',
  templateUrl: './flux-rss-stream.component.html',
  styleUrls: ['./flux-rss-stream.component.css']
})
export class FluxRssStreamComponent implements OnInit {


  flux: any;
  items: any;
  item: Object | undefined;
  title: string | undefined;
  pageOfItems: Array<any> | undefined;

  constructor(private rssService: RssService) {}

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


}
