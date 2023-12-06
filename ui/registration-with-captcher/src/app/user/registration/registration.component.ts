import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

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

  constructor(private fb: FormBuilder, private http: HttpClient) {

  }
  ngOnInit(): void {
    this.loadregiCaptcha();
  }


  loadregiCaptcha(){
    this.http.get('http://localhost:8080/user/register').subscribe((res:any)=>{
      debugger
      console.log('res ', res);
      this.img = res;
    },(err:Error)=>{
      alert('getting error');
    });
  }

}
