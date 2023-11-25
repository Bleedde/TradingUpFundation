import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';
import { Alerts } from 'src/app/shared/alerts/alerts';

@Injectable({
  providedIn: 'root'
})
export class ReadPrerecordedsServiceService {
  private alerts: Alerts = new Alerts();
  constructor(private http: HttpClient) { }

  API: string = "http://localhost:8080/class_prerecorded";

  readClassesPrerecordedService(level: number) :Observable<GenericResponse> {
    return this.http.get<GenericResponse>(this.API + "/classes_prerecorded_read" + level)
    .pipe(
      catchError((error: HttpErrorResponse) => {
        // Puedes mostrar la alerta aquí
        this.alerts.showModalPrerecorded();

        // Luego, propagar el error para que el consumidor del servicio también pueda manejarlo si es necesario
        return throwError("error");
      })
    );
  }
}
