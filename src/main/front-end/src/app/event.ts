import { Employee } from './employee';
import { Item } from './item';

export class Event {
    id: number;
    date: any;
    useStoredCash: boolean;
    totalValue: number;
    employees: Employee[];
    items: Item[];

}
