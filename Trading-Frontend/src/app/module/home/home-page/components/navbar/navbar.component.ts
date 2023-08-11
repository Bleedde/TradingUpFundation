import { Component, HostListener} from '@angular/core';
import { IMAGEN_LOGO } from 'src/app/shared/constants';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  imagen_logo = IMAGEN_LOGO;

  scrolled = false;
  private scrollTimeout: any;

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.scrolled = true;
    clearTimeout(this.scrollTimeout);

    this.scrollTimeout = setTimeout(() => {
      this.scrolled = false;
    }, 200); // Cambia el valor según la cantidad de tiempo de inactividad deseada (en milisegundos)
  }

  scroll(sectionId: string): void {
    const element = document.getElementById(sectionId);
    if(element){
      element.scrollIntoView({behavior: 'smooth', block: 'start'});
    }
  }
}
