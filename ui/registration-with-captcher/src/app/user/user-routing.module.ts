import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from './registration/registration.component';
import { ViewComponent } from './view/view.component';

const routes: Routes = [
  {path:'registration', component:RegistrationComponent},
  {path:'view', component:ViewComponent},
  {path:'', component:RegistrationComponent},
  {path:'**', redirectTo:'registration'},
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
