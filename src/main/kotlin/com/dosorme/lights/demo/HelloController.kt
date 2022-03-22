package com.dosorme.lights.demo


import com.dosorme.lights.demo.mapper.HelloMapper
import com.dosorme.lights.demo.model.UserProfile
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@CrossOrigin
@RestController
class HelloController (var mapper: HelloMapper) {
    val userMap = mutableMapOf<String, UserProfile>()

    @PostConstruct
    fun init() {
        userMap["1"] = UserProfile("1", "참새", "한라산")
        userMap["2"] = UserProfile("2", "비둘기", "우장산")
        userMap["3"] = UserProfile("3", "까치", "개화산")
    }

    @GetMapping("/api/{id}")
    fun getProfile(@PathVariable("id") id: String): UserProfile {
        // return userMap[id]
        return mapper.getUserProfile(id)
    }

    @GetMapping("/api/all")
    fun getProfileList(): List<UserProfile> {
        // return ArrayList(userMap.values)
        return mapper.getUserProfileList()
    }

    @PutMapping("/api/{id}")
    fun putProfile(
        @PathVariable("id") id: String,
        @RequestParam("name") name: String,
        @RequestParam("address") address: String
    ) {
        // userMap[id] = UserProfile(id, name, address)
        mapper.putUserProfile(id, name, address)
    }

    @PostMapping("/api/{id}")
    fun postProfile(
        @PathVariable("id") id: String,
        @RequestParam("name") name: String,
        @RequestParam("address") address: String
    ) {
        // userMap[id]?.name = name
        // userMap[id]?.address = address
        mapper.postUserProfile(id, name, address)
    }

    @DeleteMapping("/api/{id}")
    fun deleteProfile(@PathVariable("id") id: String){
        // userMap.remove(id)
        mapper.deleteUserProfile(id)
    }

    @GetMapping("/api/hello")
    fun hello() = "Hello!"

    @GetMapping("/api/test")
    fun test() = "test"
}