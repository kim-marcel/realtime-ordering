import {Component, OnInit} from '@angular/core';
import {Order} from '../../models/order.model';
import {OrderService} from '../../services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  item: string;
  quantity: number;

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
  }

  placeOrder() {
    this.orderService.placeOrder(new Order(this.item, this.quantity));
    this.item = undefined;
    this.quantity = undefined;
  }
}
