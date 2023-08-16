import { Component} from '@angular/core';
import { SLIDE1, SLIDE2, SLIDE3 } from 'src/app/shared/constants';

@Component({
  selector: 'app-carrousel',
  templateUrl: './carrousel.component.html',
  styleUrls: ['./carrousel.component.scss']
})
export class CarrouselComponent {
  slide1 = SLIDE1;
  slide2 = SLIDE2;
  slide3 = SLIDE3;

  scrollToContactSection() {
    const contactSection = document.querySelector('#contact');
    if (contactSection) {
      contactSection.scrollIntoView({ behavior: 'smooth' });
    }
  }
}
