import { Routes } from '@angular/router';

import { PhonebookentryComponent } from './phonebookentry.component';

export const PhonebookentryRoutes: Routes = [
    {
      path: '',
      children: [ {
        path: '',
        component: PhonebookentryComponent
      }]
    }
];
