import { MovieService } from './../../../service/movie.service';
import { Component, OnInit } from '@angular/core';
import { Movie} from '../../../../app/entity/movie';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

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

  deleteMovie(id: string) {
    this.movieService.deleteMovie(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  movieDetails(id: string){
    this.router.navigate(['details', id]);
  }

  updateMovie(id: string){
    this.router.navigate(['update', id]);
  }

}
