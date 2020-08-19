import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Airport } from '../airport';
import { error } from '@angular/compiler/src/util';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-view-airport',
  templateUrl: './view-airport.component.html',
  styleUrls: ['./view-airport.component.css']
})
export class ViewAirportComponent implements OnInit {

  constructor(private airportInfoService: ServiceService, private route: ActivatedRoute) { }

  searchCode:string;
  airport: Airport;
  ngOnInit(): void {

    this.route.params.subscribe(param => {
      this.searchCode = param["airportCode"];

      this.airportInfoService.getAirportByCode(this.searchCode).subscribe(
        (response) => {
          this.airport = response;
          this.airportInfoService.airport=this.airport;
        }
        ,
        (error) => {
          alert("No Airport found with code = " + this.searchCode);
        }

      );
    })
  }



}
