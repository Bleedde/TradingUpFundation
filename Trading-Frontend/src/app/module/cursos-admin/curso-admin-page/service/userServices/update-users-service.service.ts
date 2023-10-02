import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDomain } from '../../components/usuarios/domains/UserDomain';
import { GenericResponse } from '../response/GenericResponse';


@Injectable({
  providedIn: 'root'
})
export class UpdateUsersServiceService {

  constructor(private http: HttpClient) {}

    API: string = "http://localhost:8080/user";

  updateUserService(userDomain : UserDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/user_update", userDomain)
  }
}
