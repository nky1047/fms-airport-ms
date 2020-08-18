import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirportlistComponent } from './view-airportlist.component';

describe('ViewAirportlistComponent', () => {
  let component: ViewAirportlistComponent;
  let fixture: ComponentFixture<ViewAirportlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAirportlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirportlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
