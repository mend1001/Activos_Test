import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private _http:HttpClient) { }

  // Post Method For Add Employee
  postEmployee(data:any)
  {
    return this._http.post<any>("http://localhost:8080/api/v1/employees",data).pipe(map((res:any)=> {
      return res
    }))
  }

    // Get Method For All Employee
    getEmployee()
    {
      return this._http.get<any>("http://localhost:8080/api/v1/employees").pipe(map((res:any)=> {
        return res
      }))
    }
    // Get Method For All states
    getState()
    {
      return this._http.get<any>("http://localhost:8080/api/v1/states").pipe(map((res:any)=> {
        return res
      }))
    }
            // Get Method For All positions
    getPosition()
    {
      return this._http.get<any>("http://localhost:8080/api/v1/positions").pipe(map((res:any)=> {
        return res
      }))
    }

      // Put Method For Update Employee
  putEmployee(data:any, id:number)
  {
    return this._http.put<any>("http://localhost:8080/api/v1/employees/" + id,data).pipe(map((res:any)=> {
      return res
    }))
  }

  // Delete Method For Update Employee
  deleteEmployee(id:number)
  {
    return this._http.delete<any>("http://localhost:8080/api/v1/employees/" + id).pipe(map((res:any)=> {
      return res
    }))
  }
    
}
