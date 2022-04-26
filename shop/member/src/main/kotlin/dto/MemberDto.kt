package shop.member.main.dto

import shop.member.main.entity.Member
import java.util.*

data class MemberDto (
    var name : String,
    var email : String,
    var pwd : String ?= null,
    var uuid : String,
    var createdAt : Date ?= null,
    var encryptedPwd : String
){
    fun toEntity() : Member = Member().createUser(name, email, encryptedPwd, uuid)
}