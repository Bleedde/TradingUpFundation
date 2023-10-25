import { TestBed } from '@angular/core/testing';

import { UpdateClassServiceService } from './update-class-service.service';

describe('UpdateClassServiceService', () => {
  let service: UpdateClassServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateClassServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
