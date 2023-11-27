import Swal from "sweetalert2";
import { IMAGEN_LOGO } from "../constants";
export class Alerts{

    logo = IMAGEN_LOGO; 

    showModalUpdated(){
        Swal.fire({
            title: 'Actualizado con exito',
            icon: 'success',
            iconColor: '#ba74ff',
            width: 600,
            padding: "3em",
            color: "#3B216F",
            confirmButtonColor: '#3B216F',
            showConfirmButton: true,
            confirmButtonText: 'OK',
          }).then((result) => {
            if (result.value) {
              // El usuario hizo clic en OK
              window.location.reload();
            }
            else{
                setTimeout(() => {
                    window.location.reload();
                  }, 100); 
            }
            // También puedes agregar lógica adicional para otros casos si es necesario
          });
      }

      showModalCreated(){
        Swal.fire({
            title: 'Creado con exito',
            icon: 'success',
            iconColor: '#ba74ff',
            width: 600,
            padding: "3em",
            color: "#3B216F",
            confirmButtonColor: '#3B216F',
            showConfirmButton: true,
            confirmButtonText: 'OK',
          }).then((result) => {
            if (result.value) {
              // El usuario hizo clic en OK
              window.location.reload();
            }
            else{
                setTimeout(() => {
                    window.location.reload();
                  }, 100); 
            }
            // También puedes agregar lógica adicional para otros casos si es necesario
          });
      }

      showModalCreatedSolution(){
        Swal.fire({
            title: 'Respuesta Creada con Exito',
            icon: 'success',
            iconColor: '#ba74ff',
            width: 600,
            padding: "3em",
            color: "#3B216F",
            confirmButtonColor: '#3B216F',
            showConfirmButton: true,
            confirmButtonText: 'OK',
          }).then((result) => {
            if (result.value) {
              // El usuario hizo clic en OK
              window.location.reload();
            }
            else{
                setTimeout(() => {
                    window.location.reload();
                  }, 100); 
            }
            // También puedes agregar lógica adicional para otros casos si es necesario
          });
      }

      showModalDelete(){
        Swal.fire({
            title: 'Eliminado con exito',
            icon: 'error',
            iconColor: '#ba74ff',
            width: 600,
            padding: "3em",
            color: "#3B216F",
            confirmButtonColor: '#3B216F',
            showConfirmButton: true,
            confirmButtonText: 'OK',
          }).then((result) => {
            if (result.value) {
              // El usuario hizo clic en OK
              window.location.reload();
            }
            else{
                setTimeout(() => {
                    window.location.reload();
                  }, 100); 
            }
            // También puedes agregar lógica adicional para otros casos si es necesario
          });
      }

      showModalClasses(){
        Swal.fire({
            title: "Aún no se encuentran clases",
            width: 600,
            padding: "3em",
            color: "#3B216F",
            imageUrl: this.logo,
            imageWidth: 200,
            background: '#fff',
            confirmButtonColor: '#3B216F',
            timer: 1200
          });
    }

    showModalPrerecorded(){
      Swal.fire({
          title: "Aún no se encuentran clases pregrabadas",
          width: 600,
          padding: "3em",
          color: "#3B216F",
          imageUrl: this.logo,
          imageWidth: 200,
          background: '#fff',
          confirmButtonColor: '#3B216F',
          timer: 1200
        });
  }

    showModalExerciseA(){
        Swal.fire({
            title: "Aún no se encuentran respuestas",
            width: 600,
            padding: "3em",
            color: "#3B216F",
            imageUrl: this.logo,
            imageWidth: 200,
            background: '#fff',
            confirmButtonColor: '#3B216F',
            timer: 1200
          });
    }

    showModalExerciseB(){
      Swal.fire({
          title: "Aún no se encuentran ejercicios para realizar",
          width: 600,
          padding: "3em",
          color: "#3B216F",
          imageUrl: this.logo,
          imageWidth: 200,
          background: '#fff',
          confirmButtonColor: '#3B216F',
          timer: 1200
        });
  }

  showModalBooks(){
    Swal.fire({
        title: "Aún no se encuentran libros",
        width: 600,
        padding: "3em",
        color: "#3B216F",
        imageUrl: this.logo,
        imageWidth: 200,
        background: '#fff',
        confirmButtonColor: '#3B216F',
        timer: 1200
      });
}
}