import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseUrl = 'http://localhost:8080/bmo/api/v1/movies';

  constructor(private http: HttpClient) { }

  getMovie(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  // tslint:disable-next-line: ban-types
  createMovie(movie: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, movie);
  }

  // tslint:disable-next-line: ban-types
  updateMovie(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteMovie(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getListMovie(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
