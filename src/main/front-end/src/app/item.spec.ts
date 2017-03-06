import {Item} from './item';

describe('Item', () => {
  it('should create an instance', () => {
    expect(new Item()).toBeTruthy();
  });
  it('should be created', () => {
      let item = new Item({
          id: 1,
          name: 'water',
          price: 3.2,
          amount: 2});
          expect(item.name).toEqual('water');
          expect(item.price).toEqual(3.2);
      });
});
