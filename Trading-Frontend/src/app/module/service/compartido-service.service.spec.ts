import { TestBed } from '@angular/core/testing';

import { CompartidoServiceService } from './compartido-service.service';

describe('CompartidoServiceService', () => {
  let service: CompartidoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompartidoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
