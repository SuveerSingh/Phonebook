import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { PhonebookComponent } from './phonebook.component';
import { PhonebookRoutes } from './phonebook.routes';
import { LoadingModule } from 'ngx-loading';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
    imports: [
        RouterModule.forChild(PhonebookRoutes),
        CommonModule,
        FormsModule,
        MaterialModule,
        LoadingModule,
        Ng2SearchPipeModule
    ],
    declarations: [PhonebookComponent]
})

export class PhonebookModule {}
