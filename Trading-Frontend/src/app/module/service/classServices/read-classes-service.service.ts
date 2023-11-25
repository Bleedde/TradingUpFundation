import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { Alerts } from 'src/app/shared/alerts/alerts';


@Injectable({
  providedIn: 'root'
})
export class ReadClassesServiceService {
  private alerts: Alerts = new Alerts();
  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class";

  readClassesforLevelService(level: number) :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/classes_read" + level)
    .pipe(
      catchError((error: HttpErrorResponse) => {
        // Puedes mostrar la alerta aquí
        this.alerts.showModalClasses();

        // Luego, propagar el error para que el consumidor del servicio también pueda manejarlo si es necesario
        return throwError("error");
      })
    );
  }
}
