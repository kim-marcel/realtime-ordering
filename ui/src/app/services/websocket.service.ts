import {Injectable} from '@angular/core';
import {StompService} from '@stomp/ng2-stompjs';
import {Observable} from 'rxjs';
import {Message} from '@stomp/stompjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {

  private orders: Observable<Message>;

  constructor(private stompService: StompService) {
    this.orders = this.stompService.subscribe('/topic/orders');
  }

  getOrders(): Observable<Message> {
    return this.orders;
  }

  // getOrdersSubscription(): Observable<Message> {
  //   return this.stompService.subscribe('/topic/orders');
  // }

}
