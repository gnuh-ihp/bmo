import { BuyTicketComponent } from './component/buy-ticket/buy-ticket.component';
import { MovieDetailComponent } from './component/movie/movie-detail/movie-detail.component';
import { CreateMovieComponent } from './component/movie/create-movie/create-movie.component';
import { MovieListComponent } from './component/movie/movie-list/movie-list.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UpdateMovieComponent } from './component/movie/update-movie/update-movie.component';
import { BuyTicketByFilmComponent } from './component/buy-ticket-by-film/buy-ticket-by-film.component';

const routes: Routes = [{path: 'movies', component: MovieListComponent},
                        {path: 'create-movie', component: CreateMovieComponent},
                        {path: 'update/:id', component: UpdateMovieComponent},
                        {path: 'details/:id', component: MovieDetailComponent},
                        {path: 'buy-ticket', component: BuyTicketComponent},
                        {path: 'buy-ticket-by-film', component: BuyTicketByFilmComponent},
                      ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
