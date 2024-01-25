package com.xxx.controller

import com.xxx.pojo.User
import com.xxx.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/login")
    fun findByUserIdAndPassword(@RequestBody user: User): User? {
        val studentId = user.student_id ?: ""
        val password = user.password ?: ""
        println("学号：$studentId")
        println("密码：$password")
        return userService.findByUserIdAndPassword(studentId, password)
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/saveUser")
    fun addUser(@RequestBody user: User) {
        val studentId = user.student_id ?: ""
        val name = user.name ?: ""
        val password = user.password ?: ""
        val major = user.major ?: ""
        val ban = user.ban ?: ""
        val type = user.type ?: ""
        try {
            userService.addUser(studentId, name, password, major, ban, type)
        } catch (exception: Exception) {
            println("添加学生异常")
        }
    }
}
