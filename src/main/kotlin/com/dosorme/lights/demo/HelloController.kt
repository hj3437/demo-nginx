package com.dosorme.lights.demo


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @GetMapping("/api/hello")
    fun hello() = "Hello!"

    @GetMapping("/api/test")
    fun test() = "test"
}