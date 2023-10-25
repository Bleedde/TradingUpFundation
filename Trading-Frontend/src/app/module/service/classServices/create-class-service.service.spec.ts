import { TestBed } from '@angular/core/testing';

import { CreateClassServiceService } from './create-class-service.service';

describe('CreateClassServiceService', () => {
  let service: CreateClassServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateClassServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
