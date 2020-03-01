import { Http } from '@angular/http';
import { Injectable } from '@angular/core';
import 'rxjs/add/operator/map';

@Injectable()
export class SettingsProvider {
 
  private config : any;
 
  constructor(private http: Http) {
  }
 
  public loadConfig() : Promise<any>{

    console.log('HTTP GET TO PATH');

    return this.http.get("assets/client-config.json")
      .map(res => res.json())
      .toPromise()
      .then(settings => this.config = settings);
  }
 
  public get configuration(): any {
    return this.config;
  }
}