package com.park9eon.boot.handler

import com.park9eon.boot.domain.Post
import com.park9eon.boot.repository.PostRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Component
class PostHandler(
        val postRepository: PostRepository
) {
    fun index(serverRequest: ServerRequest) = ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(postRepository.findAll().toFlux())

    fun save(serverRequest: ServerRequest) = postRepository.save(serverRequest.bodyToMono<Post>().block()).let {
        ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .body(it!!.toMono())
    }
}