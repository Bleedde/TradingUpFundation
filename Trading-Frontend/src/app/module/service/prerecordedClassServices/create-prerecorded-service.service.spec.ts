import { TestBed } from '@angular/core/testing';

import { CreatePrerecordedServiceService } from './create-prerecorded-service.service';

describe('CreatePrerecordedServiceService', () => {
  let service: CreatePrerecordedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreatePrerecordedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
