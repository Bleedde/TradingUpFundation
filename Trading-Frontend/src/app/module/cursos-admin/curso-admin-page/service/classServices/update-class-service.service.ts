import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class UpdateClassServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/user";

updateUserService(userDomain : UserDomain) :Observable<GenericResponse> {
  return this.http.put<GenericResponse>(this.API + "/class_update", userDomain)
}
}
