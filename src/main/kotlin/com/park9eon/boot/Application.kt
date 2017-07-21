package com.park9eon.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by park9eon on 19/07/2017.
 */
@EnableWebMvc
@SpringBootApplication
class Application: SpringBootServletInitializer()

fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}
