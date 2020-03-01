import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';
import { ValidateOTPComponent } from './validateotp.component';
import { ValidateOTPRouting } from './validateotp.routing';
import { LoadingModule } from 'ngx-loading';

import { NouisliderModule } from 'ng2-nouislider';
import { TagInputModule } from 'ngx-chips';
import { SelectModule } from 'ng2-select';

import { FieldErrorDisplayForOTPValidationComponent } from './field-error-display/field-error-display.component'

@NgModule({
    imports: [
        RouterModule.forChild(ValidateOTPRouting),
        CommonModule,
        FormsModule,
        MaterialModule,
        LoadingModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule,
        NouisliderModule,
        TagInputModule,
        MaterialModule
    ],
    declarations: [
        ValidateOTPComponent,
        FieldErrorDisplayForOTPValidationComponent
    ]
})

export class ValidateOTPModule { }
