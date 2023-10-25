import { TestBed } from '@angular/core/testing';

import { DeleteClassServiceService } from './delete-class-service.service';

describe('DeleteClassServiceService', () => {
  let service: DeleteClassServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DeleteClassServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
