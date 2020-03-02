import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { APIService } from '../services/api.service'
import { DataService } from '../services/data.service';
import { Phonebook } from '../helper/phonebook';
import { FormControl } from '@angular/forms';
import { TooltipPosition } from '@angular/material';
import { SweetAlertComponent } from '../components/sweetalert/sweetalert.component';
import swal from 'sweetalert2';

declare var $: any;
declare interface TableData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: 'app-phonebook',
  templateUrl: './phonebook.component.html',
  styleUrls: ['./phonebook.component.scss'],
  providers: [SweetAlertComponent]
})
export class PhonebookComponent implements OnInit {

  datarowsmaster: Array<Phonebook>;
  datarows: Array<string>;

  public tableData1: TableData;

  positionOptions: TooltipPosition[] = ['below'];
  position = new FormControl(this.positionOptions[0]);

  description: "";

  constructor(public _apiservice: APIService,
    public _dataservice: DataService,
    private changeDetectorRefs: ChangeDetectorRef,
    public sweetalertComponent: SweetAlertComponent) { }

  ngOnInit() {

    this.getAllPhonebooks();

    this.tableData1 = {
      headerRow: ['#', 'Description'],
      dataRows: []
    };

  }

  getAllPhonebooks() {
    this._apiservice.listPhonebooks(this._dataservice.userId).subscribe((response) => {
      if (response) {

        if(response.phoneBookList.length == 0){
          this.displayError('There are currently no phonebooks!')
        }

        this.datarowsmaster = [];
        this.datarowsmaster = response.phoneBookList;
        this.tableData1.dataRows = [];    

        for (var i = 0; i < this.datarowsmaster.length; i++) {

          this.datarows = [];

          this.datarows.push(this.datarowsmaster[i].id.toString());
          this.datarows.push(this.datarowsmaster[i].description);

          this.tableData1.dataRows.push(this.datarows);
          this.changeDetectorRefs.detectChanges();
        }

      }
    });
  }

  edit(phonebookId, description) {
    console.log(phonebookId);
    console.log(description);
    swal({
      title: 'Coming soon',
      text: 'We will notify you once you are able to edit a phonebook',
      type: 'warning',
      confirmButtonText: 'Continue',
      confirmButtonClass: 'btn btn-success',
      buttonsStyling: false
    }).then(function (dismiss) {
    }).catch(swal.noop);
  }

  addPhonebook() {
    
    if (this.description == null) { this.displayError('Description cannot be empty'); return; }    

    this._apiservice.addPhonebook(this._dataservice.userId, this.description).subscribe((response) => {
      if (response) {
        if (response.status) {

          var thisInstance = this;

          swal({
            title: 'Success',
            text: 'New phonebook added successfully',
            type: 'success',
            confirmButtonText: 'Continue',
            confirmButtonClass: 'btn btn-success',
            buttonsStyling: false
          }).then(function (dismiss) {
            thisInstance.getAllPhonebooks();
            thisInstance.description = '';
          }).catch(swal.noop);
        }
      }
    });
  }

  displayError(message) {
    swal({
      title: 'Oops!',
      text: message,
      type: 'error',
      confirmButtonText: 'Continue',
      confirmButtonClass: 'btn btn-success',
      buttonsStyling: false
    }).then(function (dismiss) {
    }).catch(swal.noop);
  }
}
