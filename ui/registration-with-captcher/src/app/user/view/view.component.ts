import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit{
  userList: any;

  constructor(private us: UserService){

  }


  ngOnInit(): void {
    this.loadAlluser();
  }

  loadAlluser(){
    debugger
    this.us.post('/user/allUsers',{}).subscribe((res:any)=>{
      debugger
      console.log(res);
      this.userList = res;
    });
  }

}
