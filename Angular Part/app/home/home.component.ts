import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  addAirport()  {
    this.router.navigate(['/add-airport'])
  }
  viewAirportList(){
    this.router.navigate(['/view-airportlist'])
  }
  viewAirport(){
    this.router.navigate(['view-airport'])
  }
}
