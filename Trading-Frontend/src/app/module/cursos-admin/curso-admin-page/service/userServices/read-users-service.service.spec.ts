import { TestBed } from '@angular/core/testing';

import { ReadUsersServiceService } from './read-users-service.service';

describe('ReadUsersServiceService', () => {
  let service: ReadUsersServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReadUsersServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
