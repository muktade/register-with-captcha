import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ReactiveFormsModule } from '@angular/forms';
import { RegistrationComponent } from './registration/registration.component';
import { UserRoutingModule } from './user-routing.module';
import { ViewComponent } from './view/view.component';


@NgModule({
  declarations: [
    RegistrationComponent,
    ViewComponent,
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    ReactiveFormsModule
  ]
})
export class UserModule { }
