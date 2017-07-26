package com.park9eon.boot.service

import com.park9eon.boot.repository.CommentRepository
import com.park9eon.boot.repository.PostRepository
import com.park9eon.boot.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PostBoardService(
        val postRepository: PostRepository,
        val commentRepository: CommentRepository,
        val userRepository: UserRepository
) {

}