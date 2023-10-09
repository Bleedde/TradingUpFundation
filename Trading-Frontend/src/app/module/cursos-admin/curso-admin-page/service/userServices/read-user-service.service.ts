import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadUserServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/user";

  readUserService(userId: number) :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/user_read")
  }
}
