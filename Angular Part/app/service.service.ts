import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Airport } from './Airport';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  airport:Airport;
  
  private baseUrl="http://localhost:8092/airport";

  constructor(private http: HttpClient, private router: Router) { }
  

  addAirport(airport:Airport):Observable<Airport>{
    return this.http.post<Airport>(this.baseUrl+"/add",airport)
  }

  getAllAirports(){
    return this.http.get<Array<Airport>>(this.baseUrl+"/all");
  }
  
  getAirportByCode(airportCode:string):Observable<any>{
    return this.http.get(`${this.baseUrl}/view/${airportCode}`);  
  }

  deleteAirport(airports){
    return this.http.delete<Airport>(this.baseUrl+"delete/"+airports.airportCode);
  }


}
