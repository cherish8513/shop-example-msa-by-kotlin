package shop.member.main.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import shop.member.main.dto.MemberDto
import shop.member.main.service.MemberService
import shop.member.main.vo.Greeting
import shop.member.main.vo.MemberRequest
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/")
class MemberController(val greeting: Greeting, val memberService: MemberService) {

    @GetMapping("/health-check")
    fun status(servletRequest: HttpServletRequest) : String = "It's Working in User Service " + servletRequest.serverPort

    @GetMapping("welcome")
    fun welcome() : String = greeting.message

    @PostMapping("/users")
    fun createUser(@RequestBody @Valid request : MemberRequest) : ResponseEntity<Any> {
        val memberDto = MemberDto(request.name, request.email, request.pwd, "null", null, "null")
        memberService.createUser(memberDto)
        return ResponseEntity.status(201).body("Create user method is called")
    }
}