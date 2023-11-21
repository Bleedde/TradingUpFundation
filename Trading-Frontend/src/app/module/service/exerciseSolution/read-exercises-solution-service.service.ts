import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Injectable({
  providedIn: 'root'
})
export class ReadExercisesSolutionServiceService {

  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/exercise_solution";

  readExercisesService() :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/exercise_solutions_read")
  }
}
