package com.park9eon.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

/**
 * Created by park9eon on 19/07/2017.
 */
@EnableAutoConfiguration
@SpringBootApplication
class Application: SpringBootServletInitializer()

fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}
