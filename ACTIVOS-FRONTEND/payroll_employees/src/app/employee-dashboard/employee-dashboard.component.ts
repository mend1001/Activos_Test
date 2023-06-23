import { Component, OnInit } from '@angular/core';
import { FormBuilder , FormGroup} from '@angular/forms';
import { ApiService } from '../shared/api.service';
import { EmployeeModel } from './employee.model';


@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {

  formValue!: FormGroup; 

  employeeobj: EmployeeModel = new EmployeeModel;

  allemployee: any;

  allstate: any;

  allposition: any;

  btnUpdateShow:boolean = false;

  btnSaveShow:boolean = true;


  constructor(private formBuilder:FormBuilder, private api:ApiService ) { }

  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      firstName:[''],
      lastName:[''],
      emailId:[''],
      salary:[''],
      position:[''],
      state:['']
    })
    this.AllEmployee();
  }

  AddEmployee(){

    this.employeeobj.firstName = this.formValue.value.firstName;
    this.employeeobj.lastName = this.formValue.value.lastName;
    this.employeeobj.emailId = this.formValue.value.emailId;
    this.employeeobj.position = this.formValue.value.position;
    this.employeeobj.salary = this.formValue.value.salary;
    this.employeeobj.state = this.formValue.value.state;
    this.api.postEmployee(this.employeeobj).subscribe({
      next: (v) => {console.log(v)},
    error: (e) => {
      alert("Error")
      console.log(e)},
    complete: () => {
      console.log('complete')
      alert("Data Saved")
      this.AllEmployee();
      this.formValue.reset();
    } })

  }

  AllEmployee(){
    this.api.getEmployee().subscribe(res => {
      this.allemployee = res;
    })
  }

  AllState(){
    this.api.getState().subscribe(res => {
      this.allstate = res;
    })
  }

  AllPosition(){
    this.api.getPosition().subscribe(res => {
      this.allposition = res;
    })
  }

  EditEmployee(data:any){
    this.AllState();
    this.AllPosition();
    this.formValue.controls['firstName'].setValue(data.firstName);
    this.formValue.controls['lastName'].setValue(data.lastName);
    this.formValue.controls['emailId'].setValue(data.emailId);
    this.formValue.controls['position'].setValue(data.position);
    this.formValue.controls['salary'].setValue(data.salary);
    this.formValue.controls['state'].setValue(data.state);
    this.employeeobj.id = data.id;
    this.UpdateShowBtn();
    this.AllEmployee();
  }

  UpdateEmployee(){

    this.employeeobj.firstName = this.formValue.value.firstName;
    this.employeeobj.lastName = this.formValue.value.lastName;
    this.employeeobj.emailId = this.formValue.value.emailId;
    this.employeeobj.position = this.formValue.value.position;
    this.employeeobj.salary = this.formValue.value.salary;
    this.employeeobj.state = this.formValue.value.state;
    this.api.putEmployee(this.employeeobj,this.employeeobj.id).subscribe(res => {
      alert("Data Updated");
      this.AllEmployee();
      this.SaveShowBtn();
    })


  }


  DeleteEmployee(data:any){
    this.api.deleteEmployee(data.id).subscribe(res => {
      alert("Record Deleted");
      this.AllEmployee();
    })
  }

  UpdateShowBtn()
  {
    this.btnUpdateShow = true;
    this.btnSaveShow = false;
  }
  SaveShowBtn()
  {
    this.btnUpdateShow = false;
    this.btnSaveShow = true;
  }



}
