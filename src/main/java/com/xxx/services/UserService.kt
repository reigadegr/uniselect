package com.xxx.services

import com.xxx.pojo.User

interface UserService {
    fun findByUserIdAndPassword(studentId: String, password: String): User?

    fun addUser(studentId: String, name: String, password: String, major: String, ban: String, type: String)
}
