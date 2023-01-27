import { Injectable } from '@angular/core';
import { HttpService } from '../Http/http.service';
import { Command } from '../Command';

@Injectable({
  providedIn: 'root'
})
export class ProxyService {

  constructor(private http: HttpService) { }

  startSimulation(command: Command){
    return this.http.postRequest('playSimulation',command);
  }
  state() {
    return this.http.getRequest('state')
  }
}
