package shop.member.main.security

import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import shop.member.main.security.config.JwtProperties
import shop.member.main.service.LoginService
import shop.member.main.vo.RequestLogin
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(private val loginService: LoginService, private val properties : JwtProperties) : UsernamePasswordAuthenticationFilter(){

    override fun attemptAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse
    ): Authentication {
        val creds = ObjectMapper().readValue(request.inputStream, RequestLogin::class.java)

        return authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(creds.email, creds.password, ArrayList()))
    }

    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        val result = authResult?.principal as User
        val memberDto = loginService.getUserDetailsByEmail(result.username)

        val token = Jwts.builder()
            .setSubject(memberDto.uuid)
            .setExpiration(Date(System.currentTimeMillis() + properties.expirationTime.toLong()))
            .signWith(Keys.hmacShaKeyFor(properties.secret.toByteArray()), SignatureAlgorithm.HS256)
            .compact()

        response?.addHeader("token", token)
        response?.addHeader("uuid", memberDto.uuid)
    }


}