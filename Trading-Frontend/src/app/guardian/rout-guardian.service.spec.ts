import { TestBed } from '@angular/core/testing';

import { RoutGuardianService } from './rout-guardian.service';

describe('RoutGuardianService', () => {
  let service: RoutGuardianService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoutGuardianService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
