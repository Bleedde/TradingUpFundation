import { Component } from '@angular/core';
import { CHARTISMO, ELLIOT, TORO, VELAS, BOOK } from 'src/app/shared/constants';
@Component({
  selector: 'app-info-cursos',
  templateUrl: './info-cursos.component.html',
  styleUrls: ['./info-cursos.component.scss']
})
export class InfoCursosComponent {
  elliotIcon = ELLIOT;
  velas = VELAS;
  toro = TORO;
  chartismo = CHARTISMO;
  book = BOOK;
}
