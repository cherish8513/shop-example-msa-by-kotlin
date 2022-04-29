package shop.catalog.main.vo

import java.time.LocalDateTime

class ResponseCatalog {
    var productId: String ?= null
    var productName: String ?= null
    var unitPrice: Int ?= null
    var stock: Int ?= null
    var createdAt: LocalDateTime ?= null
}