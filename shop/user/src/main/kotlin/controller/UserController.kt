package shop.user.main.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class UserController {

    @PostMapping("/health-check")
    fun status() : String = "It's Working in User Service"
}