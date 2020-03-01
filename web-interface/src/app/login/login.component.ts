import { Component, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { Router } from "@angular/router";

declare var $: any;
declare var msal: any;

@Component({
    selector: 'app-login-cmp',
    templateUrl: './login.component.html'
})

export class LoginComponent implements OnInit, OnDestroy {
    test: Date = new Date();
    private toggleButton: any;
    private sidebarVisible: boolean;
    private nativeElement: Node;
    loading = false;


    constructor(private element: ElementRef,        
        private router: Router) {
        this.nativeElement = element.nativeElement;
        this.sidebarVisible = false;
    }
    

    ngOnInit() {
        var navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        const body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');
        body.classList.add('off-canvas-sidebar');
        const card = document.getElementsByClassName('card')[0];
        setTimeout(function () {
            // after 1000 ms we add the class animated to the login/register card
            card.classList.remove('card-hidden');
        }, 700);

    }


    login() {        
        console.log('login clicked');
        this.router.navigate(['/dashboard']);
    }

    ngOnDestroy() {
        const body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');
        body.classList.remove('off-canvas-sidebar');
    }

    
}
