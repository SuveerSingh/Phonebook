import { Routes } from '@angular/router';

import { LogoutComponent } from './logout.component';

export const LogoutRouting: Routes = [
    {

        path: '',
        children: [{
            path: '',
            component: LogoutComponent
        }]
    }
];
