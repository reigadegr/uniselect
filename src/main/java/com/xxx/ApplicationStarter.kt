package com.xxx

import com.xxx.startlintener.SpringStartListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@SpringBootApplication
open class ApplicationStarter {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hello world!")
            val configurableApplicationContext: ConfigurableApplicationContext =
                SpringApplication.run(ApplicationStarter::class.java, *args)

            // 向Spring上下文中添加监听器
            configurableApplicationContext.addApplicationListener(SpringStartListener())
        }
    }
}
