import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EditItemComponent} from "./edit-item/edit-item.component";
import {HomeComponent} from "./home/home.component";
import {FluxRssStreamComponent} from "./flux-rss-stream/flux-rss-stream.component";
import {ItemEditedComponent} from "./item-edited/item-edited.component";

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "flus-streaming", component: FluxRssStreamComponent},
  {path: "itemEdited/:id", component: ItemEditedComponent},
  {path: "edititem/:id", component: EditItemComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
