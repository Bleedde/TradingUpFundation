import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class CreateExerciseSolutionServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/exercise_solution";

  createExerciseSolutionService(formData: FormData): Observable<GenericResponse> {
    return this.http
    .post<GenericResponse>(this.API + "/exercise_solution_create", formData )
  }
}
