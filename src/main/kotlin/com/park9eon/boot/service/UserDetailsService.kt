package com.park9eon.boot.service

import com.park9eon.boot.domain.UserDetails
import com.park9eon.boot.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService(
        val userRepository: UserRepository
): UserDetailsService {

    override
    fun loadUserByUsername(username: String?): UserDetails {
        return UserDetails(userRepository.findById(username).get())
    }

}