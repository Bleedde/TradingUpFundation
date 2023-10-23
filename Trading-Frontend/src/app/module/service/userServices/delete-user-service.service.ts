import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { UserDomain } from '../../cursos-admin/curso-admin-page/components/usuarios/domains/UserDomain';




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
