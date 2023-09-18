package sever.code.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sever.code.order.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
