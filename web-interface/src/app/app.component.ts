import { Component, OnInit } from '@angular/core';
import { APIService } from './services/api.service'

@Component({
    selector: 'app-my-app',
    templateUrl: './app.component.html'
})

export class AppComponent implements OnInit {

    constructor(public _apiservice: APIService) { }

    ngOnInit() {
        this._apiservice.checkHealth().subscribe((response) => {
            console.log(JSON.stringify(response));
        });
    }
}
