import { TestBed } from '@angular/core/testing';

import { RoutCursosGuardianService } from './rout-cursos-guardian.service';

describe('RoutCursosGuardianService', () => {
  let service: RoutCursosGuardianService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoutCursosGuardianService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
