import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { PhonebookComponent } from './phonebook.component';
import { PhonebookRoutes } from './phonebook.routes';
import { LoadingModule } from 'ngx-loading';

@NgModule({
    imports: [
        RouterModule.forChild(PhonebookRoutes),
        CommonModule,
        FormsModule,
        MaterialModule,
        LoadingModule
    ],
    declarations: [PhonebookComponent]
})

export class PhonebookModule {}
