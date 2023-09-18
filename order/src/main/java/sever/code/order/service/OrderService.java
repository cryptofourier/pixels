package sever.code.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sever.code.order.model.Order;
import sever.code.order.repo.OrderItemRepo;
import sever.code.order.repo.OrderRepo;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;

    public OrderService(OrderRepo orderRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    public Order createOrder(Order order) {
        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        Order save = orderRepo.save(order);
        return save;
    }

    public Order getOrderById(long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

//    public Order updateOrder(Order order) {
//        return orderRepo.save(order);
//    }

    public void deleteOrderById(long id) {
        orderRepo.deleteById(id);
    }

}
