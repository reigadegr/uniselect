package com.xxx.services.impl

import com.xxx.mapper.AdminMapper
import com.xxx.pojo.Admin
import com.xxx.services.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

//@Service
//public class AdminServiceImpl implements AdminService {
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    @Override
//    public Admin findByAdminIdAndPassword(String admin_id, String password) {
////        String admin_id=adminId;
////
////        System.out.println("这里是管理员登录服务层");
////        System.out.println("管理员id"+admin_id);
////        System.out.println("管理员密码"+password);
////        System.out.println("管理员登录结束");
//
//        return adminMapper.findByAdminIdAndPassword(admin_id, password);
//    }
//}
@Service
class AdminServiceImpl : AdminService {

    @Autowired
    private lateinit var adminMapper: AdminMapper

    override fun findByAdminIdAndPassword(adminId: String, password: String): Admin? {
        // 这里是管理员登录服务层
//        println("这里是管理员登录服务层")
//        println("管理员id: $adminId")
//        println("管理员密码: $password")
//        println("管理员登录结束")

        return adminMapper.findByAdminIdAndPassword(adminId, password)
    }
}