import {Component, OnInit} from '@angular/core';
import {WebsocketService} from '../../services/websocket.service';
import {Order} from '../../models/order.model';
import {OrderService} from '../../services/order.service';

@Component({
  selector: 'app-show-orders',
  templateUrl: './show-orders.component.html',
  styleUrls: ['./show-orders.component.css']
})
export class ShowOrdersComponent implements OnInit {

  orders: Order[] = [];

  constructor(private websocketService: WebsocketService, private orderService: OrderService) {
    websocketService.getOrders().subscribe((message) => {
      this.orders.push(JSON.parse(message.body) as Order);
    });
  }

  ngOnInit() {
    this.orderService.getAllOrders().subscribe((orders: Order[]) => this.orders = orders);
  }

}
