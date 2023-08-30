import { Component } from '@angular/core';
import { IMAGEN_LOGO, LOGIN } from 'src/app/shared/constants';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginServiceService } from '../../service/login-service.service';
import { GenericResponse } from '../../response/GenericResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginImage = LOGIN;
  logo = IMAGEN_LOGO;
  userForm !: FormGroup;

  constructor(private router: Router, private formulary:FormBuilder, private loginService:LoginServiceService) {
    this.userForm = this.formulary.group({
      email : [''], 
      password : ['']
      });
   }

  

  scrollToComponent(): void {
    console.log("he entrado al metodo scrolltoCOomponent")
    this.router.navigate(['/home-page'], { fragment: 'contact' });
    setTimeout(() => {
      const element = document.getElementById('contact');
      if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    }, 500); // Espera 500 ms para dar tiempo a que Angular realice la navegación
  }

  serviceLogin(){
    console.log("he entrado al metodo");
    console.log("prueba: " + this.userForm.controls['email'].value)

    const params = {
      correo : this.userForm.controls['email'].value,
      contrasenia : this.userForm.controls['password'].value
    }


    this.loginService.loginService(params).subscribe(
      (resp: GenericResponse) => 
        console.log("esta es la respuesta: " + resp.statusCode)
    )

  }
}
