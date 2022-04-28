package shop.member.main.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import shop.member.main.dto.MemberDto
import shop.member.main.repository.MemberRepository
import java.util.*

@Service
class MemberService(val memberRepository: MemberRepository, val passwordEncoder: BCryptPasswordEncoder){
    fun createMember(memberDto: MemberDto){
        memberDto.uuid = UUID.randomUUID().toString()
        memberDto.encryptedPwd = passwordEncoder.encode(memberDto.pwd)
        memberRepository.save(memberDto.toEntity())
    }

    fun getMemberByUuId(uuid : String) : MemberDto{
        val findMember = memberRepository.findByUuid(uuid) ?: throw IllegalStateException("No User")

        val memberDto = MemberDto.of(findMember)

        return memberDto
    }
}
