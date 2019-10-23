package com.tablesdemo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Autowired
    lateinit var dataSource: DataSource

//    @Bean
//    fun makeUsers(): UserDetailsService {
//        val admin: UserDetails = User.builder()
//                .username("admin").password(encoder.encode("admin"))
//                .roles("ADMIN").build()
//
//        val user: UserDetails = User.builder()
//                .username("user").password(encoder.encode("password"))
//                .roles("USER").build()
//
//        val instructor: UserDetails = User.builder()
//                .username("instructor").password(encoder.encode("passw0rd"))
//                .roles("INSTRUCTOR").build()
//        return InMemoryUserDetailsManager(admin, user, instructor)
//    }


    @Autowired
    fun configureGlobal(authenticationManagerBuilder: AuthenticationManagerBuilder) {
        val admin: UserDetails = User.builder()
                .username("admin").password(encoder.encode("admin"))
                .roles("ADMIN").build()

        val user: UserDetails = User.builder()
                .username("user").password(encoder.encode("password"))
                .roles("USER").build()

        val instructor: UserDetails = User.builder()
                .username("instructor").password(encoder.encode("passw0rd"))
                .roles("INSTRUCTOR").build()

//        val clei: UserDetails = User.builder().username("clei").password(encoder.encode("password1"))
//                .roles("ADMIN").build()

        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder)
                .withUser(admin).withUser(user).withUser(instructor)
//                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username=?")



    }



    override fun configure(http: HttpSecurity?) {

//        http!!.authorizeRequests().mvcMatchers("/index").permitAll().anyRequest().authenticated()
//                .and().authorizeRequests().mvcMatchers("/db/**", "/api/**").hasRole("ADMIN").anyRequest().authenticated()
//                .and().authorizeRequests().mvcMatchers("/resources/**").permitAll().anyRequest().permitAll()
//                .and().formLogin().loginPage("/login-page.html").successForwardUrl("/").failureUrl("/login-error.html").permitAll()
//                .and().logout().permitAll()
////                .and().httpBasic()

        http!!.authorizeRequests()
                .mvcMatchers( "/api/**").hasRole("ADMIN").anyRequest().authenticated()
                .mvcMatchers("/", "/index").permitAll()
                .and().formLogin().loginPage("/login-page.html").defaultSuccessUrl("/home.html", true).permitAll(true)
                .and().logout().clearAuthentication(true).logoutSuccessUrl("/login-page.html").deleteCookies("JSESSIONID")
                .invalidateHttpSession(true).permitAll()
//                .and().httpBasic()

        http.csrf().disable()
        http.headers().frameOptions().disable()
    }
}