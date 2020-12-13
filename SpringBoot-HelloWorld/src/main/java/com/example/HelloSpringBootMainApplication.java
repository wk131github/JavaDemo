package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author walkinger
 * @version 1.0
 * @date 2020/12/13 22:30
 * @SpringBootApplication 标注这是一个springboot的主程序,springboot就应该运行这个类的main方法来启动SpringBoot应用
 */
@SpringBootApplication
public class HelloSpringBootMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootMainApplication.class,args);
    }
}
