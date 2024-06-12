package com.xxx.controller

import com.xxx.pojo.Teacher
import com.xxx.services.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/uniselect")
class TeacherController {
    @Autowired
    lateinit var teacherService: TeacherService

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/loginteacher")
    fun findByTeacherIdAndPassword(@RequestBody teacher: Teacher): Teacher? {
        val teacherId = teacher.teacher_id ?: ""
        val password = teacher.password ?: ""
        return teacherService.findByTeacherIdAndPassword(teacherId, password)
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping(value = ["/loginteacher2/{teacherId}/{password}"], method = [RequestMethod.GET])
    fun findByTeacherIdAndPassword2(@PathVariable teacherId: String, @PathVariable password: String): Teacher? {
        return teacherService.findByTeacherIdAndPassword(teacherId, password)
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/addteacher")
    fun insertTeacher(@RequestBody teacher: Teacher) {
        // teacher_id, name, password, description

        val teacher_id = teacher.teacher_id ?: ""
        val name = teacher.name ?: ""
        val password = teacher.password ?: ""
        val description = teacher.description ?: ""
        try {
            teacherService.insertTeacher(teacher_id, name, password, description)
        } catch (exception: Exception) {
            println("添加老师异常")
        }
    }
}
