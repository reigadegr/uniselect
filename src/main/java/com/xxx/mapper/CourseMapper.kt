package com.xxx.mapper

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
// import java.util.List
// import java.util.Map

@Mapper
interface CourseMapper {
    @Select("SELECT * FROM course")
    fun findCourseName(): List<Map<String, Any>>?

    @Insert("INSERT INTO course(name, teacher, description, num) VALUES(#{name}, #{teacher}, #{description}, #{num})")
    fun addCourse(name: String, teacher: String, description: String, num: Int): Int?

    @Delete("DELETE FROM course WHERE id = #{id}")
    fun deleteCourseById(id: Int): Int?

    @Delete("DELETE FROM course_selection WHERE course_id = #{id}")
    fun deleteCourse_selectionById(id: Int): Int?
}
