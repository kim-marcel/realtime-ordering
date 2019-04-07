import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Order} from '../models/order.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  orderUrl = 'http://localhost:8080/api/v1/orders';

  placeOrder(order: Order) {
    this.http.post(this.orderUrl, order).subscribe();
  }

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.orderUrl);
  }

}
