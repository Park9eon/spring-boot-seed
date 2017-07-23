package com.park9eon.boot.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.AutowireCapableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.ObjectPostProcessor
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override
    fun configure(http: HttpSecurity) {
        http
            .authorizeRequests()
            .antMatchers("/", "/home", "post").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll()
    }
    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth
            .inMemoryAuthentication()
            .withUser("user")
                .password("password")
                .roles("USER")
    }

    @Bean
    fun objectPostProcessor(
            beanFactory: AutowireCapableBeanFactory): ObjectPostProcessor<Any> {
        return object: ObjectPostProcessor<Any> {
            override fun <O : Any?> postProcess(`object`: O): O {
                return `object`
            }
        }
    }
}