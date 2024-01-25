//package com.xxx.startlintener;
//
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SpringStartListener implements ApplicationListener<ApplicationReadyEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        // Spring Boot应用程序已经完全启动
//        System.out.println("Spring Boot应用程序已经完全启动！");
//    }
//}
package com.xxx.startlintener

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class SpringStartListener : ApplicationListener<ApplicationReadyEvent> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        // Spring Boot应用程序已经完全启动
        println("Spring Boot应用程序已经完全启动！")
    }
}
