import { Component } from '@angular/core';
import { IMAGEN_LOGO, LOGIN } from 'src/app/shared/constants';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginServiceService } from '../../service/login-service.service';
import { GeneralResponse } from 'src/app/shared/response/GeneralResponse';
import { CompartidoServiceService } from 'src/app/module/service/compartido-service.service'
import { UserDomain } from 'src/app/module/cursos-admin/curso-admin-page/components/usuarios/domains/UserDomain';
import { GuardianValidateService } from 'src/app/guardian/guardian-validate.service';
import { GuardianValidateCursosService } from 'src/app/guardian/cursosGuardian/guardian-validate-cursos.service';
import { RoutGuardianService } from 'src/app/guardian/rout-guardian.service';
import { RoutCursosGuardianService } from 'src/app/guardian/cursosGuardian/rout-cursos-guardian.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginImage = LOGIN;
  logo = IMAGEN_LOGO;
  userForm !: FormGroup;

  constructor(private router: Router, private formulary:FormBuilder, private loginService:LoginServiceService, private compartidoServiceService: CompartidoServiceService, private routGuardianService: RoutGuardianService, private RoutCursosGuardianService: RoutCursosGuardianService) {
    this.userForm = this.formulary.group({
      email : ['', [Validators.required, Validators.email]],
      password : ['', [Validators.required, Validators.nullValidator]],
      });
   }

  
  errorMessage: string = '';

  serviceLogin(){

    if(!this.userForm.valid){
      this.userForm.markAllAsTouched();
    }
    else{
      const params = {
        email : this.userForm.controls['email'].value,
        password : this.userForm.controls['password'].value
        
      }
      
      this.loginService.loginService(params).subscribe(
        (res: GeneralResponse) => {
          console.log("respuesta " + res.message)
          if(res.objectResponse.userRole == "admin"){

            this.routGuardianService.generalTokenSave("access succesfuly")
            this.router.navigate(['cursosAdmin-page']);
            this.compartidoServiceService.setData(res.objectResponse)
          }
          if(res.objectResponse.userRole == "user"){

            this.RoutCursosGuardianService.cursosTokenSave("access succesfuly")
            this.router.navigate(['cursos-page']);
            let userModel: UserDomain;
            userModel = res.objectResponse;
            console.log("correo desde el padre a:" + 
            res.objectResponse.email + " " 
            + res.objectResponse.status + " "
            + res.objectResponse.userLevel);
            this.compartidoServiceService.setData(userModel);
          }
        },
        (error)=>{
          this.errorMessage = 'No existe nigun usuario con estos datos, verifica de nuevo o contactanos';
        }
      )
    }

    
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
}
