import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { DataService } from '../services/data.service';
import { Router } from "@angular/router";
import { AuthenticationSandbox } from '../authentication/sandbox/authentication.sandbox';
import { APIService } from '../services/api.service';
import { SweetAlertComponent } from '../components/sweetalert/sweetalert.component';
import swal from 'sweetalert2';
import { OnlineProfile } from '../services/data.service';

@Component({
    selector: 'app-profilemanagement',
    templateUrl: 'profilemanagement.component.html'
})

export class ProfileManagementComponent implements OnInit {

    loading = false; 


    currentOnlineProfile: OnlineProfile = { OnlineProfileId: 0, NsfasId: 0, Username : '', WalletGuid: '', NewRegistration: false, ForcePinReset: false };

    constructor(private router: Router,
        private authSandbox: AuthenticationSandbox,
        public _apiservice: APIService,
        public _dataservice: DataService) {
    }

    ngOnInit() {
        this._dataservice.currentOnlineProfile.subscribe(a => this.currentOnlineProfile = a);
    }

    ResetUUSDChannelPin() {

        this.loading = true;

        this._apiservice.getPanEncryptionKey().subscribe((response) => {

            this.loading = false; 

            if (response) {

                this._apiservice.resetUSSDChannelProfile().subscribe((response) => {

                    if (response.errorMessage) {
                        this.displaySweetAlertError(response.errorMessage);
                    }

                    else
                    {
                        if (response.result) {

                            swal({
                                title: 'Process Complete!',
                                text: 'Your credentials have been reset. Please follow instructions on SMS',
                                type: 'success',
                                confirmButtonClass: 'btn btn-success',
                                buttonsStyling: false
                            });
    
                        }
                        else {
                            swal({
                                title: 'Failure',
                                text: 'We were unable to reset your credentials. Please try again later.',
                                type: 'error',
                                confirmButtonClass: 'btn btn-info',
                                buttonsStyling: false
                            });
                        }
                    }

                    
                },
                error => {
                    this.displaySweetAlertError('An error occurred while processing your request. Please try again later');
                });
            }
        },
        error => {
            this.loading = false;
            this.displaySweetAlertError('An error occurred while processing your request. Please try again later');
        });
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
}
