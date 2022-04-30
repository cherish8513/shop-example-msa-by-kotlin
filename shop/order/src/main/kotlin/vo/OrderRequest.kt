package shop.order.main.vo

data class OrderRequest (
    var productId : String,
    var qty : Int,
    var unitPrice : Int
)