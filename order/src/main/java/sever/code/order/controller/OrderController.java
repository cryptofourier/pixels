package sever.code.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.code.order.model.Order;
import sever.code.order.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    public ResponseEntity<Test> test(){
        Test test = new Test();
        Map<Integer, String> items = test.getItems();
        items.put(1, "bla");
        items.put(2, "bla");

        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        System.out.println(order);
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

//    @PutMapping("/{orderId}")
//    public ResponseEntity<Order> updateOrder(@PathVariable long orderId, @RequestBody Order order) {
//        Order existingOrder = orderService.getOrderById(orderId);
//        if (existingOrder != null) {
//            order.setId(orderId);
//            Order updatedOrder = orderService.updateOrder(order);
//            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable long orderId) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder != null) {
            orderService.deleteOrderById(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
