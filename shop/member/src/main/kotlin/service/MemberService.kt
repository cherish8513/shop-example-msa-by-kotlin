package shop.member.main.service

import org.springframework.stereotype.Service
import shop.member.main.dto.MemberDto
import shop.member.main.repository.MemberRepository
import java.util.*

@Service
class MemberService(val memberRepository: MemberRepository){
    fun createUser(memberDto: MemberDto){
        memberDto.uuid = UUID.randomUUID().toString()
        memberDto.encryptedPwd = "encryptedPwd"
        memberRepository.save(memberDto.toEntity())
    }
}