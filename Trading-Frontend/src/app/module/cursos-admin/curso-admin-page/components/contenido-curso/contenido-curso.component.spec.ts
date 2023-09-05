import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContenidoCursoComponent } from './contenido-curso.component';

describe('ContenidoCursoComponent', () => {
  let component: ContenidoCursoComponent;
  let fixture: ComponentFixture<ContenidoCursoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContenidoCursoComponent]
    });
    fixture = TestBed.createComponent(ContenidoCursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
