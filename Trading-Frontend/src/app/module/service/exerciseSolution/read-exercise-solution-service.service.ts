import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadExerciseSolutionServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/exercise_solution";

  readExerciseSolutionService(params:{userEmail : string, exerciseId : number}) :Observable<GenericResponse> {
    return this.http.post<GenericResponse>(this.API + "/exercise_solution_exercises_for_user", params)
  }
}
