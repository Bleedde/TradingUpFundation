import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class DeleteBookServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/book";

  deleteBookService(id: number) :Observable<GenericResponse> {
    return this.http.delete<GenericResponse>(this.API + "/book_delete" + id)
  }
}
