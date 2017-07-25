package com.park9eon.boot.repository

import com.park9eon.boot.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, String> {
    fun findByUsername(username: String): User?
}