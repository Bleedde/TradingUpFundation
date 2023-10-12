import { TestBed } from '@angular/core/testing';

import { GuardianValidateCursosService } from './guardian-validate-cursos.service';

describe('GuardianValidateCursosService', () => {
  let service: GuardianValidateCursosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardianValidateCursosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
