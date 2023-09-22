import { TestBed } from '@angular/core/testing';

import { DeleteUserServiceService } from './delete-user-service.service';

describe('DeleteUserServiceService', () => {
  let service: DeleteUserServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteUserServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
