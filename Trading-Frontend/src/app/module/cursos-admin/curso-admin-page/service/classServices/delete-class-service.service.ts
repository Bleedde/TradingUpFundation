import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClassDomain } from '../../components/clases-grabadas/domains/ClassDomain';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class DeleteClassServiceService {

  constructor(private http: HttpClient) { }

    API: string = "http://localhost:8080/class";

  deleteUserService(userDomain :  ClassDomain) :Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.API + "/class_delete", userDomain)
  }
}
