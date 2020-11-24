import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Istudent} from '../student-info/Istudent';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  studentDetail: Istudent;
  @Output()
  studentEdit = new EventEmitter();
  @Output()
  messageEdit = new EventEmitter();


  constructor() {
  }

  ngOnInit() {
  }

  editBabe(name, age, mark) {
    this.studentDetail.name = name.value;
    this.studentDetail.age = age.value;
    this.studentDetail.mark = mark.value;
    // this.message = ;
    this.studentEdit.emit(this.studentDetail);
    this.messageEdit.emit('Edited ' + name.value);
  }
}
