import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from 'src/app/entity/movie';
import { MovieService } from 'src/app/service/movie.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-buy-ticket-by-film',
  templateUrl: './buy-ticket-by-film.component.html',
  styleUrls: ['./buy-ticket-by-film.component.css']
})
export class BuyTicketByFilmComponent implements OnInit {

  movies: Observable<Movie[]>;


  constructor(
    private movieService: MovieService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.movies = this.movieService.getListMovie();
    console.log(this.movies);
  }
  cinemaContain(){

  }



}
