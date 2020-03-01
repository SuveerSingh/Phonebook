import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { ProfileManagementComponent } from './profilemanagement.component';
import { ProfileManagementRoutes } from './profilemanagement.routes';
import { LoadingModule } from 'ngx-loading';

@NgModule({
    imports: [
        RouterModule.forChild(ProfileManagementRoutes),
        CommonModule,
        FormsModule,
        MaterialModule,
        LoadingModule
    ],
    declarations: [ProfileManagementComponent]
})

export class ProfileManagementModule {}
