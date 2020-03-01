import { Injectable } from '@angular/core';
import { Router } from "@angular/router";
import swal from 'sweetalert2';

@Injectable()
export class ErrorHandlingService {

    constructor(public router: Router) { }

    handleError(errorStatus, errorStatusText, route) {

        var _this = this;

        if (errorStatus === 401) {
            swal({
                title: 'Invalid Session',
                text: 'Oops, your session is invalid! You need to login to gain access to Mibanking',
                type: 'error',
                confirmButtonText: 'Got it!',
                confirmButtonClass: 'btn btn-success',
                buttonsStyling: false
            }).then(function (dismiss) {
                // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
                _this.router.navigate(['/' + route]);
            })
        }
        else
        {
            swal({
                title: 'Ooops, something went wrong',
                text: errorStatusText,
                type: 'error',
                confirmButtonText: 'Got it!',
                confirmButtonClass: 'btn btn-success',
                buttonsStyling: false
            }).then(function (dismiss) {
                // dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
                _this.router.navigate(['/' + route]);
            })
        }
    }

}