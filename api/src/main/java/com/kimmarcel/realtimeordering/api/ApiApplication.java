package com.kimmarcel.realtimeordering.api;


import com.kimmarcel.realtimeordering.api.models.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(ApiApplication.class, args);

        ReactiveMongoTemplate reactiveMongoTemplate = ctx.getBean(ReactiveMongoTemplate.class);
        SimpMessagingTemplate simpMessagingTemplate = ctx.getBean(SimpMessagingTemplate.class);

        Flux changeStream = reactiveMongoTemplate.changeStream(
                "realtime-example",
                "order",
                ChangeStreamOptions.empty(),
                Order.class);


        changeStream.doOnNext(event -> {
            ChangeStreamEvent<Order> changeStreamEvent = (ChangeStreamEvent<Order>) event;
            Order order = new Order(changeStreamEvent.getRaw().getFullDocument().get("item").toString(), (int) changeStreamEvent.getRaw().getFullDocument().get("quantity"));
            System.out.println(order.toString());
            simpMessagingTemplate.convertAndSend("/topic/orders", order);
        }).subscribe();

    }

}
