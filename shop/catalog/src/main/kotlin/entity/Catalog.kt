package shop.catalog.main.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Catalog : BaseTimeEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id")
    var id : Long ?= null
        private set

    @Column(nullable = false, length = 120, unique = true)
    var productId : String ?= null
        private set

    @Column(nullable = false)
    var productName : String ?= null
        private set

    @Column(nullable = false)
    var stock : Int ?= null
        private set

    @Column(nullable = false)
    var unitPrice : Int ?= null
        private set


    fun createCatalog(productId : String, productName : String, stock : Int, unitPrice : Int) : Catalog{
        val catalog = Catalog()
        catalog.productId = productId
        catalog.productName = productName
        catalog.stock = stock
        catalog.unitPrice = unitPrice

        return catalog
    }
}