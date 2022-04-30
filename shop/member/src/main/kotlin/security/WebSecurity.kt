package shop.member.main.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import shop.member.main.service.MemberService

@Configuration
@EnableWebSecurity
class WebSecurity(val memberService: MemberService, val bCryptPasswordEncoder: BCryptPasswordEncoder) : WebSecurityConfigurerAdapter(){

    @Bean
    fun passwordEncoder() : BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.authorizeRequests().antMatchers("/**")
        http.addFilter(getAuthenticationFilter())
        http.headers().frameOptions().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(memberService).passwordEncoder(bCryptPasswordEncoder)
    }

    private fun getAuthenticationFilter(): AuthenticationFilter {
        val filter = AuthenticationFilter()
        filter.setAuthenticationManager(authenticationManager())

        return filter
    }



}