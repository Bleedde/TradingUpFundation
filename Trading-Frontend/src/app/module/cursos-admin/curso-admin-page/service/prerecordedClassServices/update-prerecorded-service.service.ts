import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ClassPrerecordedDomain } from '../../components/clases-pregrabadas/domains/ClassPrerecordedDomain';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class UpdatePrerecordedServiceService {

  constructor(private http: HttpClient) {}

  API: string = "http://localhost:8080/class_prerecorded";

  updateClassPrerecordedService(classPrerecordedDomain : ClassPrerecordedDomain) :Observable<GenericResponse> {
    return this.http.put<GenericResponse>(this.API + "/class_prerecorded_update", classPrerecordedDomain)
  }
}
