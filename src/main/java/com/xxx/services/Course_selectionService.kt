package com.xxx.services

import com.xxx.pojo.Course_selection
import org.apache.ibatis.annotations.Param

// import java.util.List
// import java.util.Map

interface Course_selectionService {
    fun countCourseSelection(studentId: String, courseId: Int): Int?

    //    public int updateCourseNum(Int courseId);
    //public int updateCourseNumAdd(Int courseId);
    fun insertCourseSelection(studentId: String, courseId: Int, courseName: String): Course_selection?

    fun ShowAlreadySelect(): List<Map<String, Any>>?

    fun getSelectionByStudentAndCourse(studentId: String): List<Map<String, Any>>?

    fun deleteByStudentIdAndCourseId(
        @Param("studentId") studentId: String,
        @Param("courseId") courseId: Int
    ): List<Map<String, Any>>?
}
