export class Item {
    id: number;
    name: string;
    price: number;
    amount: number;

    constructor(values: Object = {}) {
        Object.assign(this, values);
    }

}
