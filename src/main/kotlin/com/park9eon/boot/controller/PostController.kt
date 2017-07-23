package com.park9eon.boot.controller

import com.park9eon.boot.domain.Post
import com.park9eon.boot.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by park9eon on 21/07/2017.
 */
@RestController
@RequestMapping("/post")
class PostController {
    @Autowired
    lateinit var postRepository: PostRepository
    @PostMapping
    fun save(@RequestBody post: Post) = postRepository.save(post)
    @GetMapping
    fun index() = postRepository.findAll()
}