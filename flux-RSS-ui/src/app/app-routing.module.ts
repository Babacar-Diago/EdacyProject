import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EditItemComponent} from "./edit-item/edit-item.component";

const routes: Routes = [
  {path: "edititem/:id", component: EditItemComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
