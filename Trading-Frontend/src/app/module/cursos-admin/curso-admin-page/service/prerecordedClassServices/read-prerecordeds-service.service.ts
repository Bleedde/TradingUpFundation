import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from '../response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadPrerecordedsServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class_prerecorded";

  readClassesPrerecordedService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/classes_prerecorded_read")
  }
}
