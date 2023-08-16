import { Component } from '@angular/core';
import { IMAGEN_LOGO, LOGIN } from 'src/app/shared/constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginImage = LOGIN;
  logo = IMAGEN_LOGO;
  imagenUrl = '/src/assets/img/loginImage.jpg';
}
