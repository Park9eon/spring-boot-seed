package com.park9eon.boot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by park9eon on 19/07/2017.
 */
@SpringBootApplication
@RestController
class Application {
    @RequestMapping("/")
    fun home(): String {
        return "Hello World!"
    }
    @RequestMapping("/_ah/health")
    fun healthy(): String {
        return "Still surviving."
    }
}
fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}
