import { MovieService } from './../../../service/movie.service';
import { Component, OnInit } from '@angular/core';
import {Movie} from '../../../entity/movie';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movie: Movie = new Movie();
  submitted = false;

  constructor(
    private movieService: MovieService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  newEmployee(): void {
    this.submitted = false;
    this.movie = new Movie();
  }

  save() {
    this.movieService.createMovie(this.movie)
      .subscribe(data => console.log(data), error => console.log(error));
    this.movie = new Movie();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/movies']);
  }

}
