import { Component, OnInit } from '@angular/core';
import PerfectScrollbar from 'perfect-scrollbar';
import { DataService } from '../services/data.service';

declare const $: any;

//Metadata
export interface RouteInfo {
    path: string;
    title: string;
    type: string;
    icontype: string;
    collapse?: string;
    children?: ChildrenItems[];
}

export interface ChildrenItems {
    path: string;
    title: string;
    ab: string;
    type?: string;
}

//Menu Items
export const ROUTES: RouteInfo[] = [{
    path: '/dashboard',
    title: 'Dashboard',
    type: 'link',
    icontype: 'dashboard'
},
{ 
    path: '/phonebook', 
    title: 'Phonebook Management',  
    type: 'link',
    icontype: 'book'
},
{ 
    path: '/phonebookentry', 
    title: 'Entry Management',  
    type: 'link',
    icontype: 'face'
},
{ 
    path: '/profilemanagement', 
    title: 'Category Management',  
    type: 'link',
    icontype: 'group_work'
}];


@Component({
    selector: 'app-sidebar-cmp',
    templateUrl: 'sidebar.component.html'
})

export class SidebarComponent implements OnInit {    

    Username : string = "";

    public menuItems: any[];

    isMobileMenu() {
        if ($(window).width() > 991) {
            return false;
        }
        return true;
    };

    constructor(public _dataservice: DataService) { }

    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem);        
        this.Username = this._dataservice.Username;
    }
    updatePS(): void {
        if (window.matchMedia(`(min-width: 960px)`).matches && !this.isMac()) {
            const elemSidebar = <HTMLElement>document.querySelector('.sidebar .sidebar-wrapper');
            let ps = new PerfectScrollbar(elemSidebar, { wheelSpeed: 2, suppressScrollX: true });
        }
    }
    isMac(): boolean {
        let bool = false;
        if (navigator.platform.toUpperCase().indexOf('MAC') >= 0 || navigator.platform.toUpperCase().indexOf('IPAD') >= 0) {
            bool = true;
        }
        return bool;
    }
}
