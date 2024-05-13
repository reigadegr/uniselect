package com.xxx.controller

import com.xxx.pojo.Admin
import com.xxx.services.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/uniselect")
class AdminController {

    @Autowired
    private lateinit var adminService: AdminService

    @CrossOrigin(origins = ["*"])
    @RequestMapping("/adminloginverify")
    fun findByAdminIdAndPassword(@RequestBody admin: Admin): Admin? {
        val adminId = admin.admin_id ?: ""
        val password = admin.password ?: ""
        println("这里是管理员登录控制层")
        println("管理员id: $adminId")
        println("管理员密码: $password")
        println("管理员登录结束")

        return adminService.findByAdminIdAndPassword(adminId, password)
    }
}
//@RestController
//public class AdminController {
//    @Autowired
//    private AdminService adminService;
//
//    @CrossOrigin(origins = "*")
//    @RequestMapping("/adminloginverify")
//    public Admin findByAdminIdAndPassword(@RequestBody Admin admin) {
//        String admin_id = admin.getAdmin_id();
//        String password = admin.getPassword();
//        System.out.println("这里是管理员登录控制层");
//        System.out.println("管理员id"+admin_id);
//        System.out.println("管理员密码"+password);
//        System.out.println("管理员登录结束");
//
//        return adminService.findByAdminIdAndPassword(admin_id, password);
//    }
//}
