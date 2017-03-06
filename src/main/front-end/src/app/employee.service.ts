import { Injectable } from '@angular/core';
import { Employee } from './employee';
@Injectable()
export class EmployeeService {

  constructor() { }
  employees: Employee[] = [
      {
          id: 1,
          name: 'The Good',
          email: 'good@email.com',
          monthlyContribution: 10,
          selected: false
      },
      {
          id: 2,
          name: 'The Bad',
          email: 'bad@email.com',
          monthlyContribution: 10,
          selected: false
      },
      {
          id: 3,
          name: 'The Ugly',
          email: 'ugly@email.com',
          monthlyContribution: 10,
          selected: false
      }
  ];
  getAll(): Employee[] {
      return this.employees;
  }
}
