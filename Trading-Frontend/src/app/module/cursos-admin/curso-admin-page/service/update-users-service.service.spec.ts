import { TestBed } from '@angular/core/testing';

import { UpdateUsersServiceService } from './update-users-service.service';

describe('UpdateUsersServiceService', () => {
  let service: UpdateUsersServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateUsersServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
