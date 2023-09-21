import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClasesPregrabadasComponent } from './clases-pregrabadas.component';

describe('ClasesPregrabadasComponent', () => {
  let component: ClasesPregrabadasComponent;
  let fixture: ComponentFixture<ClasesPregrabadasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClasesPregrabadasComponent]
    });
    fixture = TestBed.createComponent(ClasesPregrabadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
