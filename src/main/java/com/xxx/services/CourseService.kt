package com.xxx.services

import com.xxx.pojo.Course

// import java.util.List
// import java.util.Map

interface CourseService {
    fun findCourseName(): List<Map<String, Any>>?

    fun addCourse(course: Course): Int?

    //删除课程
    fun deleteCourseById(id: Int): Int?

    fun deleteCourse_selectionById(id: Int): Int?
}
