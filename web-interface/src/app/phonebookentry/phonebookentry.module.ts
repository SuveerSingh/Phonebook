import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { PhonebookentryComponent } from './phonebookentry.component';
import { PhonebookentryRoutes } from './phonebookentry.routes';
import { LoadingModule } from 'ngx-loading';

import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
    imports: [
        RouterModule.forChild(PhonebookentryRoutes),
        CommonModule,
        FormsModule,
        MaterialModule,
        LoadingModule,
        Ng2SearchPipeModule
    ],
    declarations: [PhonebookentryComponent]
})

export class PhonebookentryModule {}
