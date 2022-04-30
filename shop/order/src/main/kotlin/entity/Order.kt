package shop.order.main.entity

import kotlinx.serialization.Serializable
import javax.persistence.*

@Serializable
@Entity
@Table(name = "orders")
class Order : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    var id : Long ?= null
        private set

    @Column(nullable = false, length = 120, unique = true)
    var productId : String ?= null
        private set

    @Column(nullable = false)
    var qty : Int ?= null
        private set

    @Column(nullable = false)
    var unitPrice : Int ?= null
        private set

    @Column(nullable = false)
    var totalPrice : Int ?= null
        private set

    @Column(nullable = false)
    var uuid : String ?= null
    private set

    @Column(name ="order_var_id" ,nullable = false, unique = true)
    var orderId : String ?= null
    private set

    fun createOrder(productId : String, qty : Int, totalPrice : Int, unitPrice : Int, uuid : String, orderId : String) : Order{
        val order = Order()
        order.productId = productId
        order.qty = qty
        order.unitPrice = unitPrice
        order.totalPrice = totalPrice

        order.uuid = uuid
        order.orderId = orderId
        return order
    }
}