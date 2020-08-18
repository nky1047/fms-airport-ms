import { Component, OnInit } from '@angular/core';
import { Airport } from '../airport';
import { ServiceService } from '../service.service';


@Component({
  selector: 'app-add-airport',
  templateUrl: './add-airport.component.html',
  styleUrls: ['./add-airport.component.css']
})
export class AddAirportComponent implements OnInit {

  constructor(private airportInfoService:ServiceService) { }
   
  airport:Airport;

  ngOnInit(): void {
  this.airport=new Airport();
  }
  addAirport(){
    this.airportInfoService.addAirport(this.airport).subscribe(
      (success)=>{
        alert("airport Added");
      },
      (error)=>{
        alert("failed to Add Airport");
      }
    )
  }

}
