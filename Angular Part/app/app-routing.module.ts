import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddAirportComponent } from './add-airport/add-airport.component';
import { ViewAirportlistComponent } from './view-airportlist/view-airportlist.component';
import { ViewAirportComponent } from './view-airport/view-airport.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [

  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {path:'add-airport', component:AddAirportComponent},
  {path:"view-airportlist", component:ViewAirportlistComponent},
  {path:"view-airport/:airportCode",component:ViewAirportComponent},
  {path:"home", component:HomeComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
