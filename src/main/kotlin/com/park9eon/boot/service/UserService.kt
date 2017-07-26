package com.park9eon.boot.service

import com.park9eon.boot.domain.Post
import com.park9eon.boot.domain.User
import com.park9eon.boot.domain.UserRole
import com.park9eon.boot.repository.PostRepository
import com.park9eon.boot.repository.UserRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
class UserService(
        val userRepository: UserRepository,

        val postRepository: PostRepository,

        val bCryptPasswordEncoder: BCryptPasswordEncoder,

        @Value("\${security.user.name}")
        val username: String,

        @Value("\${security.user.password}")
        var password: String
) {

    @PostConstruct
    private
    fun init() {
        createAdminUser()
    }

    private
    fun createAdminUser() {
        val user = findByUsername(username)
        if (user == null)
            save(User(username = username, password = password, authorities = UserRole.ADMIN))
    }

    fun findByUsername(username: String) = userRepository.findByUsername(username)

    fun save(user: User): User {
        user.password = user.password?.let { bCryptPasswordEncoder.encode(it) }
       userRepository.save(user)
       return user
    }

    fun delete(username: String) = userRepository.delete(userRepository.findById(username).get())

}