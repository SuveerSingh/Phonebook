import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { APIService } from '../services/api.service'
import { DataService } from '../services/data.service';
import { FormControl } from '@angular/forms';
import { TooltipPosition } from '@angular/material';
import { SweetAlertComponent } from '../components/sweetalert/sweetalert.component';
import swal from 'sweetalert2';
import { PhonebookEntry } from 'app/helper/phonebookentry';

declare var $: any;
declare interface TableData {
  headerRow: string[];
  dataRows: string[][];
}

@Component({
  selector: 'app-phonebookentry',
  templateUrl: './phonebookentry.component.html',
  styleUrls: ['./phonebookentry.component.scss'],
  providers: [SweetAlertComponent]
})
export class PhonebookentryComponent implements OnInit {

  datarowsmaster: Array<PhonebookEntry>;
  datarows: Array<string>;

  public tableData1: TableData;

  positionOptions: TooltipPosition[] = ['below'];
  position = new FormControl(this.positionOptions[0]);

  description: "";
  phoneNumber: "";
  phonebooks: PhonebookEntry[];
  phonebook: PhonebookEntry;

  constructor(public _apiservice: APIService,
    public _dataservice: DataService,
    private changeDetectorRefs: ChangeDetectorRef,
    public sweetalertComponent: SweetAlertComponent) { }

  ngOnInit() {

    this.getAllPhonebooks();
    this.getAllPhonebookEntries();

    this.tableData1 = {
      headerRow: ['#', 'Phone Number', 'Description'],
      dataRows: []
    };
  }

  getAllPhonebooks() {
    this._apiservice.listPhonebooks(this._dataservice.userId).subscribe((response) => {
      if (response) {
        this.phonebooks = response.phoneBookList;
        if(response.phoneBookList.length == 0){
          this.displayError('There are currently no phonebooks. Add a phonebook before adding an entry!')
        }
      }
    });
  }

  getAllPhonebookEntries() {
    this._apiservice.listPhonebookEntries(this._dataservice.userId, 1).subscribe((response) => {
      if (response) {

        if(response.phoneBookEntryList.length == 0){
          this.displayError('There are currently no phonebooks entries!')
        }

        this.datarowsmaster = [];
        this.datarowsmaster = response.phoneBookEntryList;
        this.tableData1.dataRows = [];

        for (var i = 0; i < this.datarowsmaster.length; i++) {

          this.datarows = [];

          this.datarows.push(this.datarowsmaster[i].id.toString());
          this.datarows.push(this.datarowsmaster[i].phoneNumber);
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
      text: 'We will notify you once you are able to edit a phonebook entry',
      type: 'warning',
      confirmButtonText: 'Continue',
      confirmButtonClass: 'btn btn-success',
      buttonsStyling: false
    }).then(function (dismiss) {
    }).catch(swal.noop);
  }

  search() {

    this._apiservice.listPhonebookEntries(this._dataservice.userId, this.phonebook.id).subscribe((response) => {
      if (response) {

        console.log(response);

        this.datarowsmaster = [];
        this.datarowsmaster = response.phoneBookEntryList;
        this.tableData1.dataRows = [];

        for (var i = 0; i < this.datarowsmaster.length; i++) {

          this.datarows = [];

          this.datarows.push(this.datarowsmaster[i].id.toString());
          this.datarows.push(this.datarowsmaster[i].phoneNumber);
          this.datarows.push(this.datarowsmaster[i].description);

          this.tableData1.dataRows.push(this.datarows);
          this.changeDetectorRefs.detectChanges();
        }

      }
    });


  }

  addPhonebookEntry() {    

    if (this.phonebook == null)   { this.displayError('Please select phonebook'); return; }
    if (this.description == null) { this.displayError('Description cannot be empty'); return; }
    if (this.phoneNumber == null) { this.displayError('Phone number cannot be empty'); return; }

    this._apiservice.addPhonebookEntry(this.phonebook.id, this.description, this.phoneNumber).subscribe((response) => {
      if (response) {
        if (response.status) {

          var thisInstance = this;

          swal({
            title: 'Success',
            text: 'New phonebook entry added successfully',
            type: 'success',
            confirmButtonText: 'Continue',
            confirmButtonClass: 'btn btn-success',
            buttonsStyling: false
          }).then(function (dismiss) {
            thisInstance.getAllPhonebookEntries();
            thisInstance.description = '';
            thisInstance.phoneNumber = '';
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
