import { TestBed } from '@angular/core/testing';

import { CreateUserServiceService } from './create-user-service.service';

describe('CreateUserServiceService', () => {
  let service: CreateUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
