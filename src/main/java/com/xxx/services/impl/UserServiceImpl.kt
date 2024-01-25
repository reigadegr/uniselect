package com.xxx.services.impl

import com.xxx.mapper.UserMapper
import com.xxx.pojo.User
import com.xxx.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {
    @Autowired
    private lateinit var userMapper: UserMapper

    override fun findByUserIdAndPassword(studentId: String, password: String): User? {
        return userMapper.findByUserIdAndPassword(studentId, password)
    }

    override fun addUser(studentId: String, name: String, password: String, major: String, ban: String, type: String) {
        val userExists = userMapper.interceptRegister(studentId)
        println("返回: $userExists")
        if (userExists != 0) {
            println("该用户已存在,拦截！")
            return
        }
        userMapper.addUser(studentId, name, password, major, ban, type)
    }
}
