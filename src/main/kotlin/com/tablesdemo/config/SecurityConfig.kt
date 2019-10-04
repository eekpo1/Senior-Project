package com.tablesdemo.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Bean
    fun makeUsers(): UserDetailsService {
        val admin: UserDetails = User.builder()
                .username("admin").password(encoder.encode("admin"))
                .roles("ADMIN").build()

        val user: UserDetails = User.builder()
                .username("user").password(encoder.encode("password"))
                .roles("USER").build()

        val instructor: UserDetails = User.builder()
                .username("instructor").password(encoder.encode("passw0rd"))
                .roles("INSTRUCTOR").build()
        return InMemoryUserDetailsManager(admin, user, instructor)
    }

    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests().mvcMatchers("/db/**").hasAnyRole("ADMIN", "INSTRUCTOR")
                .and().authorizeRequests().anyRequest().authenticated().and().formLogin()
                .and().httpBasic()

        http.csrf().disable()
        http.headers().frameOptions().disable()
    }
}