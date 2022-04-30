package shop.order.main.repository;

import org.springframework.data.jpa.repository.JpaRepository
import shop.order.main.entity.Order

interface OrderRepository : JpaRepository<Order, Long> {
    fun findByOrderId(orderId : String) : Order?
    fun findByUuid(uuid : String) : Iterable<Order>
}