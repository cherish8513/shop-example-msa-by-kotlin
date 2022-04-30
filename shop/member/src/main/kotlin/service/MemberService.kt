package shop.member.main.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import shop.member.main.dto.MemberDto
import shop.member.main.repository.MemberRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class MemberService(val memberRepository: MemberRepository, val passwordEncoder: BCryptPasswordEncoder) : UserDetailsService{
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

    override fun loadUserByUsername(username: String): UserDetails {
        val findMember = memberRepository.findByEmail(username)
            ?: throw UsernameNotFoundException(username)

        return User(
            findMember.email,
            findMember.encryptedPwd,
            true,
            true,
            true,
            true,
            ArrayList())
    }
}
