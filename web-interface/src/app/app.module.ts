import { NgModule, APP_INITIALIZER } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { APP_BASE_HREF } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule,
} from '@angular/material';

import { AppComponent } from './app.component';
import * as $ from 'jquery';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FixedpluginModule } from './shared/fixedplugin/fixedplugin.module';
import { AdminLayoutComponent } from './layouts/admin/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth/auth-layout.component';
import { SweetAlertModule } from './components/sweetalert/sweetalert.module';
import { AppRoutes } from './app.routing';
import { APIService } from './services/api.service'
import { ConfigurationService } from './services/configuration.service';
import { DataService } from './services/data.service';
import { JwtHelper } from 'angular2-jwt';
import { ErrorHandlingService} from './services/errorhandling.service'
import { LoadingModule } from 'ngx-loading';
import { SettingsProvider} from './services/settings';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

export function init(settingsProvider: SettingsProvider) {
  return () => settingsProvider.loadConfig();
}

@NgModule({
  exports: [
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    SweetAlertModule
  ]
})
export class MaterialModule { }

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    FormsModule,
    RouterModule.forRoot(AppRoutes),
    HttpModule,
    MaterialModule,
    MatNativeDateModule,
    SidebarModule,
    NavbarModule,
    FooterModule,
    FixedpluginModule,
    SweetAlertModule,
    LoadingModule,
    Ng2SearchPipeModule,
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent
  ],
  bootstrap: [AppComponent],
  providers: [
    {
      'provide': APP_INITIALIZER,
      'useFactory': init,
      'deps': [SettingsProvider],
      'multi': true
    },
    SettingsProvider,
    APIService, 
    DataService,
    ConfigurationService,    
    JwtHelper, 
    ErrorHandlingService,    
  ]
})
export class AppModule { }


