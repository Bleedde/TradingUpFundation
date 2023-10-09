import { TestBed } from '@angular/core/testing';

import { ReadUserServiceService } from './read-user-service.service';

describe('ReadUserServiceService', () => {
  let service: ReadUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
