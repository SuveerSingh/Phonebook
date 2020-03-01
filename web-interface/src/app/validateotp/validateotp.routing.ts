import { Routes } from '@angular/router';
import { ValidateOTPComponent } from './validateotp.component';

export const ValidateOTPRouting: Routes = [
    {

        path: '',
        children: [{
            path: '',
            component: ValidateOTPComponent
        }]
    }
];
