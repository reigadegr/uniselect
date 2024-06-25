package com.xxx.mapper

import com.xxx.pojo.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Select("SELECT * FROM users WHERE student_id = #{student_id} AND password = #{password}")
    fun findByUserIdAndPassword(@Param("student_id") studentId: String, @Param("password") password: String): User?

    @Insert("INSERT INTO users (student_id, name, password, major, ban, type) VALUES (#{student_id}, #{name}, #{password}, #{major}, #{ban}, #{type})")
    fun addUser(
        @Param("student_id") studentId: String,
        @Param("name") name: String,
        @Param("password") password: String,
        @Param("major") major: String,
        @Param("ban") ban: String,
        @Param("type") type: String
    ): User?

    @Select("SELECT COUNT(*) FROM users WHERE student_id = #{student_id}")
    fun interceptRegister(@Param("student_id") studentId: String): Int
}
