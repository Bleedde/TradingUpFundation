import { Component } from '@angular/core';
import { IMAGEN_LOGO, LOGIN } from 'src/app/shared/constants';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginImage = LOGIN;
  logo = IMAGEN_LOGO;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  scrollToComponent(): void {
    this.router.navigate(['/home-page'], { fragment: 'contact' });
    setTimeout(() => {
      const element = document.getElementById('contact');
      if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    }, 2000); // Espera 500 ms para dar tiempo a que Angular realice la navegación
  }
}
