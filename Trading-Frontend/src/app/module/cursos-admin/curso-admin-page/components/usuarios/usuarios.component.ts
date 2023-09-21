import { Component } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent {
  /*
  userForm!: FormGroup;

  constructor(public formulary: FormBuilder){
    this.userForm = formulary.group({
      name : ['', [Validators.required]],
      email : ['', [Validators.required]],
      password : ['', [Validators.required]],
      level : ['', [Validators.required]],
      status : ['', [Validators.required]],
      backtesting : ['', [Validators.required]],
      auditedAccount : ['', [Validators.required]]
    });
  } */
  onSubmit(form: NgForm) {
    if (form.valid) {
      console.log('Formulario válido. Datos enviados:', form.value);
      // Aquí puedes agregar código adicional para enviar los datos al servidor o realizar otras acciones.
    } else {
      console.log('Formulario no válido. Por favor, complete los campos requeridos correctamente.');
    }
  }



}
