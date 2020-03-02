
import { Injectable } from '@angular/core';
import { SettingsProvider } from './settings';

@Injectable()
export class ConfigurationService {

  urls: any = {};

  constructor(public settingsProvider: SettingsProvider) {

    this.urls = {
      baseUrl: this.settingsProvider.configuration.baseUrl,
      actuatorUrl : this.settingsProvider.configuration.actuatorUrl
    };

    console.log("BASE URL : " + this.urls.baseUrl);   
  }

  geturls() {
    return this.urls;
  };

}


