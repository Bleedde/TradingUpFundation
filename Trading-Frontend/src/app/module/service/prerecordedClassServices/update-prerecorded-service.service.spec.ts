import { TestBed } from '@angular/core/testing';

import { UpdatePrerecordedServiceService } from './update-prerecorded-service.service';

describe('UpdatePrerecordedServiceService', () => {
  let service: UpdatePrerecordedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdatePrerecordedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
