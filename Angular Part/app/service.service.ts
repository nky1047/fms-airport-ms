import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Airport, AirportList } from './Airport';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  airport:Airport;
  
  private baseUrl="http://localhost:8092";

  constructor(private _http: HttpClient, private router: Router) { }
  

  addAirport(airport:Airport):Observable<Airport>{
    return this._http.post<Airport>(this.baseUrl+"/airport/add",airport)
  }

  getAllAirports():Observable<AirportList>{
    return this._http.get<AirportList>(this.baseUrl+"/airport/all");
  }
  
  getAirportByCode(airportCode:string):Observable<Airport>{
    return this._http.get<Airport>(this.baseUrl+"/airport/airportcode/"+airportCode);
  }
  deleteAirport(airports){
    return this._http.delete<Airport>(this.baseUrl+"/airport/delete/"+airports.airportCode);
  }


}
