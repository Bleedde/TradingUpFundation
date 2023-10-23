import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { UserDomain } from '../../../shared/domains/UserDomain';



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
