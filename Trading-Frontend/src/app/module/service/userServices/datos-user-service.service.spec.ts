import { TestBed } from '@angular/core/testing';

import { DatosUserServiceService } from './datos-user-service.service';

describe('DatosUserServiceService', () => {
  let service: DatosUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatosUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
