package com.park9eon.boot.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class IndexHandler {
    fun index(serverRequest: ServerRequest) = ok().render("index")
}