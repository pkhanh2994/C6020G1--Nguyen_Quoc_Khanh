import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})
export class RegisterFormComponent implements OnInit {
    userName: string;
    password: string;
  constructor() { }

  ngOnInit() {
  }

  onClickbae(data) {
    this.userName = data.email;
    this.password = data.password;
  }
}
