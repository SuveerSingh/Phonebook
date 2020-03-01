import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { LogoutComponent } from './logout.component';
import { LogoutRouting } from './logout.routing';
import { LoadingModule } from 'ngx-loading';

@NgModule({
    imports: [
        RouterModule.forChild(LogoutRouting),
        CommonModule,
        FormsModule,
        MaterialModule, 
        LoadingModule
    ],
    declarations: [LogoutComponent]
})

export class LogoutModule {}
