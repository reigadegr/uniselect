package com.xxx.services.impl

import com.xxx.mapper.Course_selectionMapper
import com.xxx.pojo.Course_selection
import com.xxx.services.Course_selectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// import java.util.List
// import java.util.Map

@Service
class Course_selectionServiceImpl : Course_selectionService {
    @Autowired
    private lateinit var course_selectionMapper: Course_selectionMapper


    override fun insertCourseSelection(studentId: String, courseId: Int, courseName: String): Course_selection? {
        val count = course_selectionMapper.countCourseSelection(studentId, courseId)
        if (count != null) {
            if (count > 0) {
                println("该课程已选择")
                return null
            }
        }
        println("这里是服务层接口实现类")
        val updatedRows = course_selectionMapper.updateCourseNum(courseId)
        if (updatedRows == 0) {
            // 处理更新失败的情况，可以抛出异常或进行其他处理
            println("选课人满了，别选了")
            return null
        }
//        System.out.println("学号是 " + studentId);
//        System.out.println("课程 " + courseId);
//        System.out.println("课程名是" + courseName);
        println("----------服务接口层结束------------")
        try {
            course_selectionMapper.insertCourseSelection(studentId, courseId, courseName)
        } catch (exception: Exception) {
            println("服务器接口层有异常")
        }
        return null
    }


    override fun countCourseSelection(studentId: String, courseId: Int): Int? {
        //选择后让课程数量-1
        return course_selectionMapper.countCourseSelection(studentId, courseId)
    }

    override fun ShowAlreadySelect(): List<Map<String, Any>>? {
        return course_selectionMapper.ShowAlreadySelect()
    }

    override fun getSelectionByStudentAndCourse(studentId: String): List<Map<String, Any>>? {
        return course_selectionMapper.getSelectionByStudentAndCourse(studentId)
    }


    override fun deleteByStudentIdAndCourseId(studentId: String, courseId: Int): List<Map<String, Any>>? {
        //删除课后，数量+1
        course_selectionMapper.updateCourseNumAdd(courseId)
        return course_selectionMapper.deleteByStudentIdAndCourseId(studentId, courseId)
    }
}
