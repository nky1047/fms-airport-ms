import { Component, OnInit } from '@angular/core';
import { Airport } from '../airport';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { ServiceService } from '../service.service';
import { CompileShallowModuleMetadata } from '@angular/compiler';

@Component({
  selector: 'app-view-airportlist',
  templateUrl: './view-airportlist.component.html',
  styleUrls: ['./view-airportlist.component.css']
})
export class ViewAirportlistComponent implements OnInit {
  airports: Airport[];

  constructor(private airportInfoService: ServiceService) { }
  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.airportInfoService.getAllAirports().subscribe(data => {
      this.airports = data;
    });
  }

  deleteAirport1(airportCode: String) {
    this.airportInfoService.deleteAirport(airportCode).subscribe(
      data => { this.reloadData() }
      )
  }
}



