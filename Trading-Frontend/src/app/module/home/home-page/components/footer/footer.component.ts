import { Component } from '@angular/core';
import { IMAGEN_LOGO } from 'src/app/shared/constants';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent {
  logo = IMAGEN_LOGO;
}
