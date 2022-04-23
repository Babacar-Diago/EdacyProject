import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RssService} from "../services/rss.service";
import {FormBuilder} from "@angular/forms";
import {Items} from "../models/items";

@Component({
  selector: 'app-item-edited',
  templateUrl: './item-edited.component.html',
  styleUrls: ['./item-edited.component.css']
})
export class ItemEditedComponent implements OnInit {

  itemId: number;
  item: any=null;

  constructor(private activatedRoute: ActivatedRoute,
              private rssService: RssService,
              private router: Router) {
    this.itemId= activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.onGetItem();
  }

  onGetItem(){
    this.rssService.getItem(this.itemId)
      .subscribe(data=>{
        this.item = data;
      },err=>{
        console.log(err);
      });
  }

  onHome() {
    this.router.navigateByUrl("");
  }

}
