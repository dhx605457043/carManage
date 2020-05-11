package com.carmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@MapperScan("com.carmanage.carDao")
@SpringBootApplication
public class CarmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarmanageApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer () {

        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index").setViewName("index");
                registry.addViewController("/driver/test").setViewName("driver/test");
                registry.addViewController("/driver/driverAdd").setViewName("driver/driverAdd");
//                registry.addViewController("/design").setViewName("design");
//                registry.addViewController("/carEdit").setViewName("carEdit");
//                registry.addViewController("/system").setViewName("system");
//                registry.addViewController("/insert").setViewName("insert");
//                registry.addViewController("/carList").setViewName("carList");


            }
        };
        return adapter;
    }
}
