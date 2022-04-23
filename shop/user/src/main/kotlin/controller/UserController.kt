package shop.user.main.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import shop.user.main.vo.Greeting
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/")
class UserController(val greeting: Greeting) {

    @GetMapping("/health-check")
    fun status(servletRequest: HttpServletRequest) : String = "It's Working in User Service " + servletRequest.serverPort

    @GetMapping("welcome")
    fun welcome() : String = greeting.message
}