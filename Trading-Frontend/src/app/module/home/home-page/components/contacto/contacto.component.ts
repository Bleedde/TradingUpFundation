import { Component, QueryList } from '@angular/core';
import { QRCODE } from 'src/app/shared/constants';
import { FormBuilder, FormGroup, Validator } from '@angular/forms';


@Component({
  selector: 'app-contacto',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.scss']
})
export class ContactoComponent {
  QR = QRCODE;

  mensaje = "Espero que te encuentres muy bien. En nombre de todo el equipo de TradingUpFundation, queremos agradecerte por tu interés y confianza en nosotros como tu socio en el mundo del trading.   Sabemos que cada paso en tu camino como trader es crucial, y es por eso que hemos diseñado cursos excepcionales para llevarte al siguiente nivel. Nuestra pasión por el trading y el compromiso con la educación financiera nos han llevado a crear programas que te proporcionarán las herramientas necesarias para tomar decisiones informadas y estratégicas en los mercados.   Nuestros cursos están cuidadosamente elaborados y cubren una amplia gama de temas, desde conceptos básicos hasta estrategias avanzadas. Ya sea que estés comenzando tu viaje en el trading o desees perfeccionar tus habilidades, tenemos algo para ti. Algunos de los beneficios que nuestros estudiantes han experimentado incluyen:   - Comprender los fundamentos del trading en los mercados financieros.   - Desarrollar estrategias sólidas respaldadas por análisis técnico y fundamental.   - Aprender a gestionar el riesgo de manera efectiva y a proteger tus inversiones."
}
