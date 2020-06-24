import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyTicketByFilmComponent } from './buy-ticket-by-film.component';

describe('BuyTicketByFilmComponent', () => {
  let component: BuyTicketByFilmComponent;
  let fixture: ComponentFixture<BuyTicketByFilmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuyTicketByFilmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuyTicketByFilmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
