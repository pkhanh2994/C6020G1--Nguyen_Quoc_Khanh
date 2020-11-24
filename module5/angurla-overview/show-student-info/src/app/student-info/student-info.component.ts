import { Component, OnInit } from '@angular/core';
import {Istudent} from './Istudent';
import {studentsDao} from './studentsDao';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit {
  studentList: Istudent[] = studentsDao;
  student: Istudent;
  messageEdit: string;
  constructor() { }

  ngOnInit() {
  }


  studentDetail(studentInfo: Istudent) {
    this.student = studentInfo;
  }

  editStudent(studentDit: Istudent) {
    this.student = studentDit;
  }

  getMessage(message: string) {
    this.messageEdit = message;
  }
}
