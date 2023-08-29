import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoAdminPageComponent } from './curso-admin-page.component';

describe('CursoAdminPageComponent', () => {
  let component: CursoAdminPageComponent;
  let fixture: ComponentFixture<CursoAdminPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CursoAdminPageComponent]
    });
    fixture = TestBed.createComponent(CursoAdminPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
