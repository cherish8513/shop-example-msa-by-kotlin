package shop.member.main.service

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import shop.member.main.dto.MemberDto
import shop.member.main.repository.MemberRepository
import java.util.*

@Service
class MemberService(val memberRepository: MemberRepository, val passwordEncoder: BCryptPasswordEncoder){
    fun createUser(memberDto: MemberDto){
        memberDto.uuid = UUID.randomUUID().toString()
        memberDto.encryptedPwd = passwordEncoder.encode(memberDto.pwd)
        memberRepository.save(memberDto.toEntity())
    }
}