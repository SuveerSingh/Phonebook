import { Component, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { Router } from "@angular/router";


declare var $: any;
declare var msal: any;

@Component({
    selector: 'app-logout-cmp',
    templateUrl: './logout.component.html'
})

export class LogoutComponent implements OnInit {

    constructor(private router: Router) {
        
    }


    ngOnInit() {                
        this.router.navigate(["/login"]);
    }


    
}
