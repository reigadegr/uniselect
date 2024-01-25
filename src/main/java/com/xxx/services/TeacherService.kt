package com.xxx.services

import com.xxx.pojo.Teacher

interface TeacherService {
    fun findByTeacherIdAndPassword(teacherId: String, password: String): Teacher?

    fun insertTeacher(teacherId: String, name: String, password: String, description: String)
}
