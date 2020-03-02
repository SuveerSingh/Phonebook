import { Component, OnInit } from '@angular/core';
import swal from 'sweetalert2';

@Component({
  selector: 'app-categorymanagement',
  templateUrl: './categorymanagement.component.html',
  styleUrls: ['./categorymanagement.component.scss']
})
export class CategorymanagementComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    swal({
      title: 'Coming soon!',
      text: 'We are currently category shedding ... ',
      type: 'error',
      confirmButtonText: 'Continue',
      confirmButtonClass: 'btn btn-success',
      buttonsStyling: false
    }).then(function (dismiss) {
    }).catch(swal.noop);
  }

}
