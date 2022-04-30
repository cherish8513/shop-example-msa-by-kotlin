package shop.order.main.vo

import java.time.LocalDateTime

class ResponseOrder {
    var productId: String ?= null
    var qty: Int ?= null
    var unitPrice: Int ?= null
    var totalPrice: Int ?= null
    var createdAt: LocalDateTime ?= null

    var orderId: String ?= null
}