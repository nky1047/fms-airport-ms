import { Component, OnInit } from '@angular/core';
import { Airport } from '../airport';

import { Router } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-view-airportlist',
  templateUrl: './view-airportlist.component.html',
  styleUrls: ['./view-airportlist.component.css']
})
export class ViewAirportlistComponent implements OnInit {
   airports: Airport[];
  
   constructor(private airportInfoService:ServiceService) { }
  ngOnInit() {
    this.airportInfoService.getAllAirports().subscribe(

      airports => this.airports = airports.airportList

    );

  }

  
  
  deleteAirport(airport: Airport): void { if (confirm("sure to delete"))
      this.airportInfoService.deleteAirport(airport)
        .subscribe( data => {
          this.airports = this.airports.filter(u => u !== airport);});
        
    }
    
  
  }
  

