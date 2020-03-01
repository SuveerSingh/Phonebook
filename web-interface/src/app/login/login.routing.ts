import { Routes } from '@angular/router';

import { LoginComponent } from './login.component';

export const LoginRouting: Routes = [
    {

        path: '',
        children: [{
            path: '',
            component: LoginComponent
        }]
    }
];
