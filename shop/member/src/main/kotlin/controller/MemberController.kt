package shop.member.main.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import shop.member.main.dto.MemberDto
import shop.member.main.service.MemberService
import shop.member.main.vo.Greeting
import shop.member.main.vo.MemberRequest
import shop.member.main.vo.MemberResponse
import shop.member.main.vo.ResponseOrder
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/member-service/members")
class MemberController(val greeting: Greeting, val memberService: MemberService) {

    @GetMapping("/health-check")
    fun status(servletRequest: HttpServletRequest) : String = "It's Working in Member Service " + servletRequest.serverPort

    @GetMapping("welcome")
    fun welcome() : String = greeting.message

    @PostMapping
    fun createUser(@RequestBody @Valid request : MemberRequest) : ResponseEntity<Any> {
        val memberDto = MemberDto(request.name, request.email, request.pwd, "null", null, "null")
        memberService.createMember(memberDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("Create user method is called")
    }

    @GetMapping("/{uuid}")
    fun getUser(@PathVariable uuid : String) : ResponseEntity<MemberResponse>{
        val memberDto = memberService.getMemberByUuId(uuid)
        val list : List<ResponseOrder> = emptyList()
        val response = MemberResponse(memberDto.email, memberDto.name, memberDto.uuid, list)

        return ResponseEntity.status(HttpStatus.OK).body(response)
    }
}