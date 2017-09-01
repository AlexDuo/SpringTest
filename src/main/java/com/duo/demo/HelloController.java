package com.duo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author DuoZhang
 * @Date UTC 2017/8/31 13:00
 * @ProjectName SpringTest
 * @PackageName com.duo.demo
 */
@RestController
public class HelloController {




    @RequestMapping("/hello")
    public String hello(){

        return "Hello Spring Controller!";

    }


    /* Spring Boot 返回Json数据
    在这个实体中，我们只进行了Set 方法
    在返回的demo实例中我们却得到了 Json 对象
    这是因为SpringBoot 默认使用的Json 解析框架是jackson(存在于Maven的依赖包中)
    * */
    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();

        demo.setId(1);
        demo.setName("DuoZhang");
        demo.setCreateTime(new Date());
        demo.setRemarks("This is remark");

        return demo;
    }
}
