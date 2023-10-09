import { CanActivateFn } from '@angular/router';

export const myGuardGuard: CanActivateFn = (route, state) => {
  return true;
};
