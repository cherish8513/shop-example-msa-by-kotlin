package shop.member.main.vo

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class MemberRequest (

    @field:NotEmpty(message = "name can't be null")
    @field:Size(min = 2, max = 6, message = "name must be equal or grater than 2 characters and less than  6 characters")
    var name : String,

    @field:Email
    @field:Size(min = 2, message = "Email not be less than two characters")
    var email : String,

    @field:NotEmpty(message = "password can't be null")
    @field:Size(min = 7, max = 12, message = "password must be equal or grater than 7 characters and less than  12 characters")
    var pwd : String,
)