package shop.order.main.controller

import org.modelmapper.ModelMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import shop.order.main.dto.OrderDto
import shop.order.main.service.OrderService
import shop.order.main.vo.OrderRequest
import shop.order.main.vo.ResponseOrder
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/orders")
class OrderController(val orderService: OrderService) {

    @GetMapping("/health-check")
    fun status(servletRequest: HttpServletRequest) : String = "It's Working in Catalog Service " + servletRequest.serverPort


    @PostMapping("/{uuid}")
    fun createOrder(@PathVariable uuid : String, @RequestBody @Valid request : OrderRequest) : ResponseEntity<Any> {
        val orderDto = OrderDto(request.productId, request.qty, request.unitPrice, null, null, null)
        orderDto.uuid = uuid
        orderService.createOrder(orderDto)

        return ResponseEntity.status(HttpStatus.CREATED).body("Create order method is called")
    }

    @GetMapping("/{uuid}")
    fun getOrder(@PathVariable uuid : String) : ResponseEntity<List<ResponseOrder>> {
        val allOrders = orderService.getOrdersByUuid(uuid)

        val result =  mutableListOf<ResponseOrder>()

        for (order in allOrders){
            result.add(ModelMapper().map(order, ResponseOrder::class.java))
        }

        return ResponseEntity.status(HttpStatus.OK).body(result)
    }

}