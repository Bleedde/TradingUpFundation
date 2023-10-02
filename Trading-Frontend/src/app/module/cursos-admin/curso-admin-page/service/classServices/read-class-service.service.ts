import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadClassServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class";

  readUsersService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/classes_search")
  }
}
