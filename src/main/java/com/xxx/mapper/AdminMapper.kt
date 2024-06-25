package com.xxx.mapper

import com.xxx.pojo.Admin
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

//@Mapper
//public interface AdminMapper {
//    @Select("SELECT * FROM admin WHERE admin_id = #{adminId} AND password = #{password}")
//    Admin findByAdminIdAndPassword(@Param("adminId") String admin_id, @Param("password") String password);
//}
@Mapper
interface AdminMapper {
    @Select("SELECT * FROM admin WHERE admin_id = #{adminId} AND password = #{password}")
    fun findByAdminIdAndPassword(@Param("adminId") adminId: String, @Param("password") password: String): Admin?
}
