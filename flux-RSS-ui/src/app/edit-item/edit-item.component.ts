import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {RssService} from "../services/rss.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-item',
  templateUrl: './edit-item.component.html',
  styleUrls: ['./edit-item.component.css']
})
export class EditItemComponent implements OnInit {

  itemId: number;
  itemFormGroup?: FormGroup;

  constructor(private activatedRoute: ActivatedRoute,
              private rssService: RssService,
              private fb: FormBuilder,
              private router: Router) {
    this.itemId= activatedRoute.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.rssService.getItem(this.itemId)
      .subscribe(item => {
        this.itemFormGroup=this.fb.group({
          id:[item.id, Validators.required],
          title:[item.title, Validators.required],
          description:[item.description, Validators.required],
        })
      });
  }

  redirect(id:any){
    this.router.navigateByUrl("/itemEdited/"+id);
  }

  onUpdateItem() {
    this.rssService.updateItem(this.itemFormGroup?.value, this.itemId)
      .subscribe(data =>{
        console.log(data)
        alert("Success Item update");
        this.redirect(this.itemId);
      });
  }

}
