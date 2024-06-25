package com.xxx.services.impl

import com.xxx.mapper.TeacherMapper
import com.xxx.pojo.Teacher
import com.xxx.services.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl : TeacherService {
    @Autowired
    private lateinit var teacherMapper: TeacherMapper


    override fun findByTeacherIdAndPassword(teacherId: String, password: String): Teacher? {
        return teacherMapper.findByTeacherIdAndPassword(teacherId, password)
    }


    override fun insertTeacher(teacherId: String, name: String, password: String, description: String) {
        val userExists = teacherMapper.interceptRegister(teacherId)
        println("返回: " + userExists)
        if (userExists != 0) {
            System.out.println("该教师已存在,拦截！")
            return
        }
        teacherMapper.insertTeacher(teacherId, name, password, description)
    }
}
