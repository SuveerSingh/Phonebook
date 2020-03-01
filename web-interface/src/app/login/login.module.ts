import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { LoginComponent } from './login.component';
import { LoginRouting } from './login.routing';
import { LoadingModule } from 'ngx-loading';

@NgModule({
    imports: [
        RouterModule.forChild(LoginRouting),
        CommonModule,
        FormsModule,
        MaterialModule, 
        LoadingModule
    ],
    declarations: [LoginComponent]
})

export class LoginModule {}
