package shop.order.main.service

import org.springframework.stereotype.Service
import shop.order.main.dto.OrderDto
import shop.order.main.entity.Order
import shop.order.main.repository.OrderRepository
import java.util.*

@Service
class OrderService(val orderRepository: OrderRepository) {

    fun createOrder(orderDto: OrderDto){
        orderDto.orderId = UUID.randomUUID().toString()
        orderDto.totalPrice = (orderDto.qty * orderDto.unitPrice)
        orderRepository.save(orderDto.toEntity())
    }

    fun getOrdersByUuid(uuid : String) : Iterable<Order>{
        return orderRepository.findByUuid(uuid)
    }

    fun getOrdersByOrderId(orderId : String) : OrderDto{
        val findOrder = orderRepository.findByOrderId(orderId) ?: throw IllegalStateException("No Order")
        return OrderDto.of(findOrder)
    }
}