package com.xxx.controller

import com.xxx.pojo.Course_selection
import com.xxx.services.Course_selectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// import java.util.List
// import java.util.Map

@RestController
@RequestMapping("/uniselect")
class Course_selectionController {
    @Autowired
    private lateinit var courseSelectionservice: Course_selectionService

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/Course_selection_insert")
    fun insertCourseSelection(@RequestBody course_selection: Course_selection): Course_selection? {

        println("这里是控制层")
        val studentId = course_selection.student_id ?: ""
        val courseId = course_selection.course_id
        val courseName = course_selection.course_name ?: ""
        println("----------控制层结束------------")
        try {
            return courseId?.let { courseSelectionservice.insertCourseSelection(studentId, it, courseName) }
        } catch (exception: Exception) {
            println("控制层有异常")
        }
        return course_selection
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/Course_selection_already_select")
    fun ShowAlreadySelect(): List<Map<String, Any>>? {
        return courseSelectionservice.ShowAlreadySelect()
    }


    @CrossOrigin(origins = ["*"])
    @RequestMapping("/Course_selection_already_select_withid")
    fun getSelectionByStudentAndCourse(@RequestBody course_selection: Course_selection): List<Map<String, Any>>? {
        //可以使用请求体解决null问题
        val studentId = course_selection.student_id ?: ""
//        System.out.println("这里是ID控制层");
//        System.out.println("学生id "+student_id);
        return courseSelectionservice.getSelectionByStudentAndCourse(studentId)
    }

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/Course_selection_already_select_delete")
    fun deleteByStudentIdAndCourseId(@RequestBody course_selection: Course_selection): List<Map<String, Any>>? {
        //可以使用请求体解决null问题
        val studentId = course_selection.student_id ?: ""
        val courseId = course_selection.course_id
//        System.out.println("学号：："+student_id);
//        System.out.println("课程id：："+course_id);
        try {
            courseId?.let { courseSelectionservice.deleteByStudentIdAndCourseId(studentId, it) }
        } catch (exception: Exception) {
            println("退课接口出现异常")
        }
        return null
    }
}
