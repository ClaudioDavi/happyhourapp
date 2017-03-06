import { Component, OnInit, ViewChild, ViewContainerRef} from '@angular/core';
import { MdSidenav, MdDialog, MdDialogConfig, MdDialogRef } from '@angular/material';
import { EventService } from './event.service';
import { EmployeeService } from './employee.service';
import { Event } from './event';
import { Employee } from './employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Happy Hour';
  selectedEvent: Event;
  events: Event[] = [];
  employee: Employee = {
      id: 1,
      name: 'The Good',
      email: 'good@email.com',
      monthlyContribution: 10
  };

  constructor(private eventService: EventService,
      private vcr: ViewContainerRef,
      private mdDialog: MdDialog) {}

  ngOnInit() {
      this.events = this.eventService.getAll();
  }
  showDetails(event: Event) {
      this.selectedEvent = event;
  }
  showDialog() {
    const dialogConfig = new MdDialogConfig();
    dialogConfig.viewContainerRef = this.vcr;
  }
  addGoer(event: Event, employee: Employee) {
      event.employees.push(employee);
  }
 }
