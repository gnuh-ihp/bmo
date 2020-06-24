import { MovieService } from './../../../service/movie.service';
import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/entity/movie';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  id: string;
  movie: Movie;
  constructor(private route: ActivatedRoute,
              private router: Router,
              private movieService: MovieService) { }

  ngOnInit(): void {
    this.movie = new Movie();

    this.id = this.route.snapshot.params['id'];

    this.movieService.getMovie(this.id)
      .subscribe(data => {
        console.log(data);
        this.movie = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['movies']);
  }

}
