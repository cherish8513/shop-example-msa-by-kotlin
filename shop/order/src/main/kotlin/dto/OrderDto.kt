package shop.order.main.dto

import kotlinx.serialization.Serializable
import shop.order.main.entity.Order

@Serializable
data class OrderDto (
    var productId : String,
    var qty : Int,
    var unitPrice : Int,
    var totalPrice : Int ?= null,
    var orderId : String ?= null,
    var uuid : String ?= null
) {
    fun toEntity() : Order = Order().createOrder(productId, qty, totalPrice!!, unitPrice, uuid!!, orderId!!)
    companion object Singleton{
        fun of(order: Order) : OrderDto = OrderDto(
            order.productId!!,
            order.qty!!,
            order.unitPrice!!,
            order.totalPrice!!,
            order.orderId!!,
            order.uuid!!
        )
    }
}