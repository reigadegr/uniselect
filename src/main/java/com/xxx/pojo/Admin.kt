package com.xxx.pojo
//@AllArgsConstructor
//@Data
//@NoArgsConstructor

//public class Admin {
//    private Integer id;
//    private String admin_id;
//    private String name;
//    private String password;
//}
//可以为空
data class Admin(
    val id: Int? = null,
    val admin_id: String? = null,
    val name: String? = null,
    val password: String? = null
)
//不可为空
//data class Admin(
//        val id: Integer,
//        val admin_id: String,
//        val name: String,
//        val password: String
//)
//


