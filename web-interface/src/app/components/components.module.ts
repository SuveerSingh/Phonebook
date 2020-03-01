import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../app.module';

import { ButtonsComponent } from './buttons/buttons.component';
import { ComponentsRoutes } from './components.routing';
import { GridSystemComponent } from './grid/grid.component';
import { IconsComponent } from './icons/icons.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { PanelsComponent } from './panels/panels.component';
import { SweetAlertModule } from './sweetalert/sweetalert.module';
import { TypographyComponent } from './typography/typography.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ComponentsRoutes),
    FormsModule,
    MaterialModule,
    SweetAlertModule
  ],
  declarations: [
      ButtonsComponent,
      GridSystemComponent,
      IconsComponent,
      NotificationsComponent,
      PanelsComponent,
      TypographyComponent
  ]
})

export class ComponentsModule {}
