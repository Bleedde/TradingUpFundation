import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadBookServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/book";

  readBookService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/book_read")
  }
}
