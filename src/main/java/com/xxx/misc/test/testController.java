package com.xxx.misc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    private testService testservice;

    //允许8080端口跨域请求
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin(origins = "*")
    @RequestMapping("/fid")
    public Test fid(Integer id) {
        return testservice.fid(id);
    }
}
