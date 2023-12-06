import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'user', loadChildren() {
      return import('./user/user.module').then((m) => m.UserModule);
    },
  },
  {
    path: '', redirectTo:'user/registration', pathMatch:'prefix',
  },
  {
    path: '**', redirectTo:'user/registration', pathMatch:'prefix',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
