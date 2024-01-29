package com.xxx.mapper

import com.xxx.pojo.Course_selection
import org.apache.ibatis.annotations.*

// import java.util.List
// import java.util.Map

@Mapper
interface Course_selectionMapper {

    //校验课程是否已经选择
    @Select("SELECT COUNT(*) FROM course_selection WHERE student_id = #{studentId} AND course_id = #{courseId}")
    fun countCourseSelection(studentId: String, courseId: Int): Int?

    //选课后让课程数量-1
    @Update("UPDATE course SET num = num - 1 WHERE id = #{courseId}")
    fun updateCourseNum(courseId: Int): Int?

    //退课后课程数量+1
    @Update("UPDATE course SET num = num + 1 WHERE id = #{courseId}")
    fun updateCourseNumAdd(courseId: Int): Int?

    //选课
    @Insert(
        "INSERT INTO course_selection (student_id, course_id, course_name) " +
                "VALUES (#{studentId}, #{courseId}, #{courseName})"
    )
    fun insertCourseSelection(studentId: String, courseId: Int, courseName: String): Course_selection?


    //展示已选列表
    @Select("SELECT * FROM course_selection")
    fun ShowAlreadySelect(): List<Map<String, Any>>?

    //根据用户id展示已经选择的课程
    @Select("SELECT * FROM course_selection WHERE student_id = #{studentId}")
    fun getSelectionByStudentAndCourse(@Param("studentId") studentId: String): List<Map<String, Any>>?

    @Delete("DELETE FROM course_selection WHERE student_id = #{studentId} AND course_id = #{courseId}")
    fun deleteByStudentIdAndCourseId(
        @Param("studentId") studentId: String,
        @Param("courseId") courseId: Int
    ): List<Map<String, Any>>?
}
