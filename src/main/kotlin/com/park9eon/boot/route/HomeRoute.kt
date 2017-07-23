package com.park9eon.boot.route

import com.park9eon.boot.handler.IndexHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class HomeRoute(
   val indexHandler: IndexHandler
) {
    @Bean
    fun homeRouter() = router {
        GET("/", indexHandler::index)
    }
}