package com.park9eon.boot.route

import com.park9eon.boot.handler.PostHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

/**
 * Created by park9eon on 21/07/2017.
 */
@Configuration
class PostRoute(
        val postHandler: PostHandler
) {
    @Bean
    fun postRouter() = router {
        (accept(MediaType.APPLICATION_JSON) and "/post").nest {
            GET("/", postHandler::index)
            POST("/", postHandler::save)
        }
    }
}
