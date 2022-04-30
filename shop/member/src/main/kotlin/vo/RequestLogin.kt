package shop.member.main.vo

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class RequestLogin {
    @field:NotEmpty(message = "email can't be null")
    @field:Size(min = 2, message = "email must be equal or grater than 2 characters")
    @field:Email
    var email: String ?= null

    @field:NotEmpty(message = "email can't be null")
    @field:Size(min = 8, message = "password must be equal or grater than 8 characters")
    var password: String ?= null
}