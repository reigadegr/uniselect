package com.xxx.services.impl

import com.xxx.mapper.CourseMapper
import com.xxx.pojo.Course
import com.xxx.services.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// import java.util.List
// import java.util.Map

@Service
class CourseServiceImpl : CourseService {
    @Autowired
    private lateinit var courseMapper: CourseMapper


    override fun findCourseName(): List<Map<String, Any>>? {
        return courseMapper.findCourseName()
    }


    override fun addCourse(course: Course): Int? {
        val name = course.name ?: ""
        val teacher = course.teacher ?: ""
        val description = course.description ?: ""
        val num = course.num
        return num?.let { courseMapper.addCourse(name, teacher, description, it) }
    }


    override fun deleteCourseById(id: Int): Int? {
        courseMapper.deleteCourse_selectionById(id)
        return courseMapper.deleteCourseById(id)
    }

    override fun deleteCourse_selectionById(id: Int): Int? {
        return courseMapper.deleteCourse_selectionById(id)
    }
}
