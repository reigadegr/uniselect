package com.xxx.services

import com.xxx.pojo.Admin

interface AdminService {
    fun findByAdminIdAndPassword(adminId: String, password: String): Admin?
}
