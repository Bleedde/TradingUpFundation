import { Component } from '@angular/core';
import { MISSION, MISSION1, VISION, VISION1, VISION2 } from 'src/app/shared/constants';

@Component({
  selector: 'app-vision-mision',
  templateUrl: './vision-mision.component.html',
  styleUrls: ['./vision-mision.component.scss']
})
export class VisionMisionComponent {
  mision = MISSION;
  vision = VISION;
  vision1 = VISION1;
  vision2 = VISION2;
  mision1 = MISSION1;
}
