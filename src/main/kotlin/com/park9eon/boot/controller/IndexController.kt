package com.park9eon.boot.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping
    fun index(model: Model) = "index".apply {
        model.addAttribute("message", "Hello, World!")
    }
}