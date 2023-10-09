import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CompartidoServiceService {

  private data: any;

  setData(data: any) {
    this.data = data;
  }

  getData() {
    return this.data;
  }
}
