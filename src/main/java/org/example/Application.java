package org.example;

import org.example.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringBoot 启动类
 *
 * @author trang
 */
@SpringBootApplication(scanBasePackages = {"org.example"})
@MapperScan("org.example.mapper")
public class Application  {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        System.out.println("ss");
    }




}