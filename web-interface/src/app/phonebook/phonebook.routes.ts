import { Routes } from '@angular/router';

import { PhonebookComponent } from './phonebook.component';

export const PhonebookRoutes: Routes = [
    {
      path: '',
      children: [ {
        path: '',
        component: PhonebookComponent
      }]
    }
];
