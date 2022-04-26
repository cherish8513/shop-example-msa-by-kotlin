package shop.member.main.vo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Greeting {
    @Value("\${greeting.message}")
    lateinit var message: String
}