import { Component, OnInit } from '@angular/core';
import { BuyTicketByFilmComponent } from '../buy-ticket-by-film/buy-ticket-by-film.component';

@Component({
  selector: 'app-buy-ticket',
  templateUrl: './buy-ticket.component.html',
  styleUrls: ['./buy-ticket.component.css']
})
export class BuyTicketComponent implements OnInit {

  declarations: [
    BuyTicketByFilmComponent
  ];


  constructor() { }

  ngOnInit(): void {
  }

}
