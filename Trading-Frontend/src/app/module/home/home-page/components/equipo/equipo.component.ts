import { Component } from '@angular/core';
import { PERSON1, PERSON2 } from 'src/app/shared/constants';

@Component({
  selector: 'app-equipo',
  templateUrl: './equipo.component.html',
  styleUrls: ['./equipo.component.scss']
})
export class EquipoComponent {
  person1 = PERSON1;
  person2 = PERSON2;
}
