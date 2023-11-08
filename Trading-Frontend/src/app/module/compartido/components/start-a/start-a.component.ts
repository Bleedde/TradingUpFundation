import { Component, OnInit } from '@angular/core';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service';
import { DatosUserServiceService } from 'src/app/module/service/userServices/datos-user-service.service';
import { ReadUserIdService } from 'src/app/module/service/userServices/read-user-id.service';
import { GRAFICEXERCISE, STARTIMAGE, WALLPAPER, WALLPAPER1 } from 'src/app/shared/constants';
import { UserDomain } from 'src/app/shared/domains/UserDomain';
import { GenericResponse } from 'src/app/shared/response/GenericResponse';

@Component({
  selector: 'app-start-a',
  templateUrl: './start-a.component.html',
  styleUrls: ['./start-a.component.scss']
})
export class StartAComponent implements OnInit{
  wallpaper = WALLPAPER;
  wallpaper1 = WALLPAPER1;
  image1 = STARTIMAGE;
  userLevel!: string;
  userRole!: string;

  constructor(private datosUserServiceService: DatosUserServiceService, private readUserIdService: ReadUserIdService, private compartidoServiceService: CompartidoServiceService){
    
  }

  ngOnInit(): void {
    const userId = this.datosUserServiceService.getUserId(); // Recupera el email del localStorage
    this.readUserIdService.readUserId(userId!).subscribe(
      (response: GenericResponse) => {
        if (response) {
          if (response.httpResponse === 200) {
            this.userRole = response.objectResponse.userRole;
            if(this.userRole == "admin"){
              this.userLevel = "Administrador"
            }
            else{
              this.userLevel = response.objectResponse.userLevel;
              this.userLevel = "Nivel " + this.userLevel;
              console.log(this.userLevel); // Accede a this.user.email aquí
            }
          } else {
            console.error("El servidor respondió con un error:", response.message);
          }
        } else {
          console.error("Respuesta del servidor vacía o no válida");
        }
      },
      (error) => {
        console.error("Error al obtener los datos del usuario por email:", error);
      }
    );
  }

}
