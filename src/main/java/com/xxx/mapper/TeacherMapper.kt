package com.xxx.mapper

import com.xxx.pojo.Teacher
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface TeacherMapper {
    @Select("SELECT * FROM teacher WHERE teacher_id = #{teacherId} AND password = #{password}")
    fun findByTeacherIdAndPassword(@Param("teacherId") teacherId: String, @Param("password") password: String): Teacher?

    @Insert("INSERT INTO teacher (teacher_id, name, password, description) VALUES (#{teacherId}, #{name}, #{password}, #{description})")
    fun insertTeacher(teacherId: String, name: String, password: String, description: String)

    @Select("SELECT COUNT(*) FROM teacher WHERE teacher_id = #{teacher_id}")
    fun interceptRegister(@Param("teacher_id") teacher_id: String): Int?
}

