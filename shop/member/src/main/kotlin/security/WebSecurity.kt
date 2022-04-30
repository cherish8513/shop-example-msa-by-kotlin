package shop.member.main.security

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import shop.member.main.security.config.JwtProperties
import shop.member.main.service.LoginService

@EnableWebSecurity
class WebSecurity(val loginService: LoginService, val bCryptPasswordEncoder: BCryptPasswordEncoder, val properties : JwtProperties) : WebSecurityConfigurerAdapter(){

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.addFilter(getAuthenticationFilter())
            .authorizeRequests()
            .antMatchers("/**").permitAll()
        http.headers().frameOptions().disable()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(loginService).passwordEncoder(bCryptPasswordEncoder)
    }

    private fun getAuthenticationFilter(): AuthenticationFilter {
        val filter = AuthenticationFilter(loginService, properties)
        filter.setAuthenticationManager(authenticationManager())

        return filter
    }
}