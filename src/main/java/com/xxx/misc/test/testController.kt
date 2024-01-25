package com.xxx.misc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 class testController {
    @Autowired
    private lateinit var testservice: testService

    //允许8080端口跨域请求
    //@CrossOrigin(origins = "http://localhost:8080")
    @CrossOrigin(origins = ["*"])
    @RequestMapping("/fid")
    fun  fid(id:Int) :Test?{
        return testservice.fid(id);
    }
}
