import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { myGuardGuard } from './my-guard.guard';

describe('myGuardGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => myGuardGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
