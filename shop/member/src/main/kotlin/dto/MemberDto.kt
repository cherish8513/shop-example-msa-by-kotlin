package shop.member.main.dto

import shop.member.main.entity.Member
import java.time.LocalDateTime

data class MemberDto (
    var name : String,
    var email : String,
    var pwd : String ?= null,
    var uuid : String,
    var createdAt : LocalDateTime ?= null,
    var encryptedPwd : String
){
    fun toEntity() : Member = Member().createMember(name, email, encryptedPwd, uuid)
    companion object Singleton{
        fun of(member: Member) : MemberDto = MemberDto(
            member.name!!,
            member.email!!,
            null,
            member.uuid!!,
            null,
            member.encryptedPwd!!
        )
    }
}