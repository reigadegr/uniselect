package com.xxx.controller

import com.xxx.pojo.Course
import com.xxx.services.CourseService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/uniselect")
class CourseController(private val courseService: CourseService) {

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/courses")
    fun findCourseName(): List<Map<String, Any>>? {
        return courseService.findCourseName()
    }


    @CrossOrigin(origins = ["*"])
    @RequestMapping("/addcourse")
    fun addCourse(@RequestBody course: Course): Int {
        //name, teacher, description, num
        try {
            courseService.addCourse(course)
        } catch (exception: Exception) {
            println("添加课程异常")
        }
        return 0
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/deletecourse")
    fun deleteCourseById(@RequestBody course: Course): Int {
        val id = course.id
        println("这里是删除课程刚改的")
//        System.out.println(id);

//        表示如果 id 不为 null，则执行 let 中的代码块，
//        将 it 作为参数传递给 deleteCourseById 方法。
//        如果 id 为 null，则直接跳过 let 中的代码块，不会执行其中的代码。
//        使用这种方式可以避免因为 id 为 null 而导致的空指针异常。
        try {
            id?.let { courseService.deleteCourseById(it) }
        } catch (exception: Exception) {
            println("删除课程信息异常")
        }
//        System.out.println("删除课程结束");
        return 0
    }

}
