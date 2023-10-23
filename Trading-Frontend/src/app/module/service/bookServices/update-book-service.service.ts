import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { BookDomain } from '../../../shared/domains/BookDomain';


@Injectable({
  providedIn: 'root'
})
export class UpdateBookServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/book";

  updateBookService(bookDomain: BookDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/book_update", bookDomain)
  }
}
