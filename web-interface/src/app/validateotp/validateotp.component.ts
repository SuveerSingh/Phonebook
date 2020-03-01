import { Component, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { DataService, OnlineProfile } from '../services/data.service';
import { Router } from "@angular/router";
import { AuthenticationSandbox } from '../authentication/sandbox/authentication.sandbox';
import { APIService } from '../services/api.service';
import { SweetAlertComponent } from '../components/sweetalert/sweetalert.component';
import swal from 'sweetalert2';

import { FormControl, FormGroupDirective, NgForm, Validators, FormGroup } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { FormBuilder, AbstractControl } from '@angular/forms';


declare var $: any;
declare var msal: any;

@Component({
    selector: 'app-validateotp',
    templateUrl: './validateotp.component.html'
})

export class ValidateOTPComponent implements OnInit, OnDestroy {

    test: Date = new Date();
    private toggleButton: any;
    private sidebarVisible: boolean;
    private nativeElement: Node;

    otp = '';

    loading = false;

    constructor(private element: ElementRef,
        private authService: AuthService,
        private router: Router,
        private authSandbox: AuthenticationSandbox,
        public _apiservice: APIService,
        public _dataservice: DataService,
        private formBuilder: FormBuilder) {
        this.nativeElement = element.nativeElement;
        this.sidebarVisible = false;
    }

    user: any;
    token: string;
    onlineProfile: OnlineProfile = { OnlineProfileId: 0, NsfasId: 0, Username: '', WalletGuid: '', NewRegistration: false, ForcePinReset: false };

    ngOnInit() {

        var navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        const body = document.getElementsByTagName('body')[0];
        body.classList.add('login-page');
        body.classList.add('off-canvas-sidebar');
        const card = document.getElementsByClassName('card')[0];
        setTimeout(function () {
            // after 1000 ms we add the class animated to the login/register card
            card.classList.remove('card-hidden');
        }, 700);


        this.user = this.authSandbox.getUser();
        this.token = this.authSandbox.getToken();

        this._dataservice.currentOnlineProfile.subscribe(a => this.onlineProfile = a);

        this.type = this.formBuilder.group({
            // To add a validator, we must first convert the string value into an array. The first item in the array is the default value if any, then the next item in the array is the validator. Here we are adding a required validator meaning that the firstName attribute must have a value in it.
            // text: [null, Validators.required],
            // email: [null, [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]],
            otp: [null, Validators.required]
        });

    }

    ngOnDestroy() {

        const body = document.getElementsByTagName('body')[0];
        body.classList.remove('login-page');
        body.classList.remove('off-canvas-sidebar');
    }

    displaySweetAlertError(message) {

        swal({
            title: 'We apologise for not being to able to process your request',
            text: message,
            type: 'error',
            confirmButtonText: 'Ok',
            confirmButtonClass: 'btn btn-info',
            buttonsStyling: false
        }).then(function (dismiss) {
            // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'

        }).catch(swal.noop);
    }

    displaySweetAlertErrorWithRedirect(message, router, path) {

        swal({
            title: 'We apologise for not being to able to process your request',
            text: message,
            type: 'error',
            confirmButtonText: 'Ok',
            confirmButtonClass: 'btn btn-info',
            buttonsStyling: false
        }).then(function (dismiss) {
            // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'

            router.navigate([path]);

        }).catch(swal.noop);
    }

    resendOTP() {
        this.router.navigate(['/linkprofiletodigitalid']);
    }

    validateOTP() {

        if (this.type.valid) {

            var router = this.router;

            this.loading = true;

            this._apiservice.validateOTP(this.otp).subscribe((response) => {

                this.loading = false;

                if (response) {

                    console.log(response);

                    if (response.errorMessage) {
                        this.displaySweetAlertError(response.errorMessage);
                    }
                    else {

                        if (!response.validated) {
                            if (response.expired) {
                                this.authSandbox.logout();
                                this.displaySweetAlertErrorWithRedirect("Oh no, maximum amount of attempts reached. This process will now be cancelled", router, '/login');
                            }
                            else {
                                this.displaySweetAlertError("Oh no, our records do not match the pin that you've given us!");
                            }

                        }
                        else {

                            if (!this.onlineProfile.ForcePinReset) {
                                swal({
                                    title: 'Process Complete!',
                                    text: 'That looks great. Your credentials have been confirmed',
                                    type: 'success',
                                    confirmButtonClass: 'btn btn-success',
                                    buttonsStyling: false
                                }).then(function (dismiss) {
                                    router.navigate(['/dashboard']);
                                }).catch(swal.noop);
                            }
                            else {
                                swal({
                                    title: 'Process Complete!',
                                    text: 'That looks great. Your credentials have been confirmed. Your card PIN has not been set. Please set PIN.',
                                    type: 'success',
                                    confirmButtonClass: 'btn btn-success',
                                    buttonsStyling: false
                                }).then(function (dismiss) {
                                    router.navigate(['/cardmanagement']);
                                }).catch(swal.noop);
                            }


                        }
                    }
                }
                else {
                    this.displaySweetAlertErrorWithRedirect("Unable to complete registration. Please try again", router, "/login");
                }
            },
                error => {
                    this.loading = false;
                    this.displaySweetAlertErrorWithRedirect('Unable to complete registration. Please try again', router, "/login");
                });

        }
        else {
            this.displaySweetAlertError('Invalid input. Please provide the correct information');
        }
    }

    type: FormGroup;

    isFieldValid(form: FormGroup, field: string) {
        return !form.get(field).valid && form.get(field).touched;
    }

    displayFieldCss(form: FormGroup, field: string) {
        return {
            'has-error': this.isFieldValid(form, field),
            'has-feedback': this.isFieldValid(form, field)
        };
    }

    validateAllFormFields(formGroup: FormGroup) {
        Object.keys(formGroup.controls).forEach(field => {
            console.log(field);
            const control = formGroup.get(field);
            if (control instanceof FormControl) {
                control.markAsTouched({ onlySelf: true });
            } else if (control instanceof FormGroup) {
                this.validateAllFormFields(control);
            }
        });
    }
}

export class MyErrorStateMatcher implements ErrorStateMatcher {
    isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
        const isSubmitted = form && form.submitted;
        return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
    }
}
