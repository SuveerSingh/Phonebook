import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SweetAlertComponent } from './sweetalert.component';
//import { CardManagementRoutes } from './carmanagement.routes';


@NgModule({
    imports: [
        //RouterModule.forChild(CardManagementRoutes),
        CommonModule,
        FormsModule,
        
    ],
    declarations: [SweetAlertComponent]
})

export class SweetAlertModule {}
