import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/app/entity/movie';
import { ActivatedRoute, Router } from '@angular/router';
import { MovieService } from 'src/app/service/movie.service';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {

  id: string;
  movie: Movie;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private movieService: MovieService) { }

  ngOnInit(): void {
    this.movie = new Movie();

    this.id = this.route.snapshot.params.id;

    this.movieService.getMovie(this.id)
      .subscribe(data => {
        console.log(data);
        this.movie = data;
      }, error => console.log(error));
  }


  updateEmployee() {
    this.movieService.updateMovie(this.id, this.movie)
      .subscribe(data => console.log(data), error => console.log(error));
    this.movie = new Movie();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/movies']);
  }

  onSubmit() {
    this.updateEmployee();
  }

}
