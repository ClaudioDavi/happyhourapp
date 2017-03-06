import { Injectable } from '@angular/core';
import { Event } from './event';
import { Employee } from './employee';

@Injectable()
export class EventService {

  constructor() { }

  events: Event[] = [
    {
        id: 1,
        date: '06/03/2016',
        useStoredCash: false,
        totalValue: 12,
        employees: [
            // { id: 1, name: 'claudio', email: 'claudio@email.com', monthlyContribution: 50},
            // {id: 2, name: 'daniel',  email: 'daniel@email.com', monthlyContribution: 75}
        ],
        items: []
    },
      {
          id: 2,
          date: '07/03/2016',
          useStoredCash: true,
          totalValue: 55,
          employees: [],
          items: []
      },
      {
          id: 3,
          date: '08/03/2016',
          useStoredCash: false,
          totalValue: 160,
          employees: [],
          items: []
      }
  ];
  getAll(): Event[] {
      return this.events;
  }

}
