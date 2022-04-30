package shop.member.main.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import shop.member.main.dto.MemberDto
import shop.member.main.repository.MemberRepository

@Service
class LoginService(val memberRepository: MemberRepository) : UserDetailsService {

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

    fun getUserDetailsByEmail(email : String) : MemberDto{
        val findMember = memberRepository.findByEmail(email) ?: throw UsernameNotFoundException(email)

        return MemberDto.of(findMember)
    }
}