import { TestBed } from '@angular/core/testing';

import { DeletePrerecordedServiceService } from './delete-prerecorded-service.service';

describe('DeletePrerecordedServiceService', () => {
  let service: DeletePrerecordedServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeletePrerecordedServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
