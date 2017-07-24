package com.park9eon.boot.service

import com.park9eon.boot.domain.Post
import com.park9eon.boot.domain.User
import com.park9eon.boot.repository.PostRepository
import com.park9eon.boot.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        val userRepository: UserRepository,
        val postRepository: PostRepository
) {
    fun save(user: User): User {
       userRepository.save(user)

       postRepository.save(
               Post(content = "Hello, World!",
                       user = user))

       return user
    }

    fun delete(username: String) = userRepository.delete(userRepository.findById(username).get())
}