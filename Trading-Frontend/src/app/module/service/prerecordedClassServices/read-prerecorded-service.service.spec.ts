import { TestBed } from '@angular/core/testing';

import { ReadPrerecordedServiceService } from './read-prerecorded-service.service';

describe('ReadPrerecordedServiceService', () => {
  let service: ReadPrerecordedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadPrerecordedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
