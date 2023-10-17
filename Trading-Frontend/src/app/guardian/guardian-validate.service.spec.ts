import { TestBed } from '@angular/core/testing';

import { GuardianValidateService } from './guardian-validate.service';

describe('GuardianValidateService', () => {
  let service: GuardianValidateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardianValidateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
