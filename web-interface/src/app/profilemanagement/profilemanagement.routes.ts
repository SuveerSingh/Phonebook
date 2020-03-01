import { Routes } from '@angular/router';

import { ProfileManagementComponent } from './profilemanagement.component';

export const ProfileManagementRoutes: Routes = [
    {

      path: '',
      children: [ {
        path: '',
        component: ProfileManagementComponent
    }]
}
];
