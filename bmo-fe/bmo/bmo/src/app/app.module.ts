import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MovieListComponent } from './component/movie/movie-list/movie-list.component';
import { CreateMovieComponent } from './component/movie/create-movie/create-movie.component';
import { MovieDetailComponent } from './component/movie/movie-detail/movie-detail.component';
import { UpdateMovieComponent } from './component/movie/update-movie/update-movie.component';
import { BuyTicketComponent } from './component/buy-ticket/buy-ticket.component';
import { BuyTicketByFilmComponent } from './component/buy-ticket-by-film/buy-ticket-by-film.component';


@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    CreateMovieComponent,
    MovieDetailComponent,
    UpdateMovieComponent,
    BuyTicketComponent,
    BuyTicketByFilmComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
