package com.park9eon.boot.controller

import com.park9eon.boot.domain.Post
import com.park9eon.boot.repository.PostRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(
        val postRepository: PostRepository
) {
    @GetMapping
    fun findAll() = postRepository.findAll()

    @PostMapping
    fun save(@RequestBody post: Post) = postRepository.save(post)
}