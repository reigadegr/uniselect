package com.xxx.misc.test;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface testMapper {
    //    @Select("select * from test where id = #{id}") public Test fid(Integer id);
    @Select("select * from test where id = #{id}")
    public Test fid(@Param("id") Integer id);
}
