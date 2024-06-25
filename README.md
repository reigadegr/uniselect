## 技术栈: SpringBoot+vue+MySQL
选课系统\
## 部署说明
- 进入项目的src/main/resources,修改application.yml的数据库MySQL的密码
- 创建uniselect表，执行项目里的uniselect.sql
- 找到项目根目录的run_rs.exe，双击，即可启动springboot后端程序
- 进入uniselect文件夹，这里是vue前端页面
- 一样的，双击run_rs.exe，即可运行vue项目
- 根据vue给出的地址，访问即可

## 获取Release:
- 使用本项目GitHub action功能，自动化构建MySQL密码分别为1234和root的版本
- 可以直接下载构建好的zip，下载解压后双击startup.bat即可启动
- 下载地址: https://github.com/reigadegr/spbootvue/actions/runs/9661320292
## 一键运行脚本:run_rs:
- 使用rust重构的项目启动脚本
- 访问https://github.com/reigadegr/run_rs/actions/runs/9629482555 可下载

## 基本逻辑：
1，定义实体,添加getter,setter方法，有无参的构造方法
```java
//com.xxx.mapper.test.java
package com.xxx.mapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class test {
    private Integer id;
    private  String name;
}
```

2，
(1)写mapper 接口，给mapper接口类加注解@Mapper
(2)方法体内写 sql语句。
```java
@Select("select * from test where id = #{id}")
```
(3)定义函数。
完整代码：

```java
package com.xxx.mapper;

import com.xxx.misc.test.Test;
import com.xxx.pojo.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface testMapper {
    @Select("select * from test where id = #{id}")
    public Test fid(Integer id);
}

```
3,写service接口

```java
package com.xxx.services;

import com.xxx.misc.test.Test;

public interface testService {
    public Test fid(Integer id);
}
```
4,创建接口实现类，继承services接口

```java
package com.xxx.services.impl;

import com.xxx.misc.test.testMapper;
import com.xxx.misc.test.testService;
import com.xxx.misc.testMapper;
import com.xxx.misc.test.Test;
import com.xxx.pojo.test;
import com.xxx.misc.test.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//给类添加service注解
@Service
public class testServiceImpl implements testService {
    //注入testmapper对象
    @Autowired
    private testMapper testmapper;

    @Override
    public Test fid(Integer id) {
        //直接返回处理结果
        return testmapper.fid(id);
    }
}
```
5，创建controller

```java
package com.xxx.controller;

import com.xxx.misc.test.Test;
import com.xxx.pojo.test;
import com.xxx.misc.test.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private testService testservice;

    @RequestMapping("/fid")
    public Test fid(Integer id) {
        return testservice.fid(id);
    }
}

```


