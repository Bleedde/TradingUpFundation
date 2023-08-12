import { Component, QueryList } from '@angular/core';
import { QRCODE } from 'src/app/shared/constants';

@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.scss']
})
export class ContactoComponent {
  QR = QRCODE;
}
