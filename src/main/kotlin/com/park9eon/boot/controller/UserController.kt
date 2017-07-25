package com.park9eon.boot.controller

import com.park9eon.boot.domain.User
import com.park9eon.boot.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
        val userService: UserService
) {
    @PostMapping
    fun save(@RequestBody user: User) = userService.save(user)

    @DeleteMapping("/{username}")
    fun delete(@PathVariable username: String) = userService.delete(username)
}