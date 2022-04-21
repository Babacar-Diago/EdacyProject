import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {RssService} from "../services/rss.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  itemId: number | undefined;
  productFormGroup?: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private rssService: RssService,
              private fb: FormBuilder) {
    //this.itemId=activatedRoute.snapshot.params.id;
  }

  ngOnInit(): void {

  }

}
