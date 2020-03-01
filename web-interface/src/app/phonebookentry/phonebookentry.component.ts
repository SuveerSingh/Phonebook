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
  phonebooks : [];
  phonebook: PhonebookEntry;

  constructor(public _apiservice: APIService,
    public _dataservice: DataService,
    private changeDetectorRefs: ChangeDetectorRef,
    public sweetalertComponent: SweetAlertComponent) { }

  ngOnInit() {

    this.getAllPhonebooks();
    this.getAllPhonebookEntries();

    this.tableData1 = {
      headerRow: ['Id', 'Phone Number', 'Description'],
      dataRows: []
    };
  }

  getAllPhonebooks() {
    this._apiservice.listPhonebooks(this._dataservice.userId).subscribe((response) => {
      if (response) {
        this.phonebooks = response.phoneBookList;        
      }
    });
  }

  getAllPhonebookEntries() {
    this._apiservice.listPhonebookEntries(this._dataservice.userId, 1).subscribe((response) => {
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

  edit(phonebookId, description) {
    console.log(phonebookId);
    console.log(description);
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
    console.log(this.description);
    console.log(this.phoneNumber);
    console.log(this.phonebook.id);

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
}
