package shop.catalog.main.dto

import kotlinx.serialization.Serializable

@Serializable
data class CatalogDto (
    val productId : String,
    val qty : Int,
    val unitPrice : Int,
    val totalPrice : Int,
    val orderId : String,
    val userId : String
)