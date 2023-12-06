import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  
  userForm = this.fb.group({
    id: '',
    name: '',
    email: '',
    captcha: '',
    hiddenCaptcha: '',
    realCaptcha: '',
  });
  img: any;
  userInfo: any;
  
  constructor(private fb: FormBuilder, private userService: UserService) {
    
  }
  ngOnInit(): void {
    this.loadregiCaptcha();
  }

  
  loadregiCaptcha(){
    const payload = this.userForm.value;
    debugger
    this.userService.post('/user/register', payload).subscribe((res:any)=>{
      debugger
      console.log('res ', res);
      this.img = res;
      this.userForm.get('hiddenCaptcha')?.setValue(this.img.hiddenCaptcha);
    },(err:Error)=>{
      alert(err);
    });
  }

  save() {
    const payload = this.userForm.value;
    this.userService.post('/user/save',payload).subscribe((res:any)=>{
      debugger
      console.log('res ', res);
      this.img = res;
      this.userInfo = res;
      this.userForm.get('hiddenCaptcha')?.setValue(res.hiddenCaptcha);
      // this.userForm.get('hiddenCaptcha')?.setValue(res.hiddenCaptcha);
    });
  }
}
