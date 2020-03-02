import { Routes } from '@angular/router';

import { CategorymanagementComponent } from './categorymanagement.component';

export const CategorymanagementRoutes: Routes = [
    {
      path: '',
      children: [ {
        path: '',
        component: CategorymanagementComponent
      }]
    }
];
