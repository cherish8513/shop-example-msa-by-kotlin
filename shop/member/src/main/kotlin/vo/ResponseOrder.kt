package shop.member.main.vo

import java.time.LocalDateTime

data class ResponseOrder (
    var productId : String,
    var qty : Int,
    var unitPrice : Int,
    var totalPrice : Int,
    var createdAt : LocalDateTime,
    var orderId : String
)