import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDomain } from '../components/usuarios/domains/UserDomain';
import { GenericResponse } from './response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class DeleteUserServiceService {

  constructor(private http: HttpClient) { }

    API: string = "http://localhost:8080/user";

  deleteUserService(userDomain : UserDomain) :Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.API + "/user_delete", userDomain)
  }
  
}
