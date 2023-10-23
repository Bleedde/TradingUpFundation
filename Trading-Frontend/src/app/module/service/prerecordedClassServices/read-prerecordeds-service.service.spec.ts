import { TestBed } from '@angular/core/testing';

import { ReadPrerecordedsServiceService } from './read-prerecordeds-service.service';

describe('ReadPrerecordedsServiceService', () => {
  let service: ReadPrerecordedsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadPrerecordedsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
