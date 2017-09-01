package com.duo.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
/*如果我们要使用第三方的json解析框架的话：
1. 我们需要在pom.xml中引入相应的依赖
2. 需要在DemoApplication中继承 WebMvcConfigurerAdapter 重写方法 并添加我们自己定义的Json解析框架
* */
@SpringBootApplication
/*让DemoApplications 继承 WebMvcConfigurerAdapter
并重写 其中的 configureMessageConverters 方法
* */
public class DemoApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

/*让Spring Boot使用我们自己引入的Json解析框架*/
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
/* 1. new一个 FastJsonHttpMessageConverter Http消息转换 对象
   2. 添加FastJson的配置信息 比如：是否要格式化返回的json数据
   3. 在convert中添加配置信息
   4. 将convert添加到converters当中
* */
//		1. new一个 FastJsonHttpMessageConverter （Http消息转换 对象）
		FastJsonHttpMessageConverter FastConverter = new FastJsonHttpMessageConverter();
//		2. 添加FastJson的配置信息 比如：是否要格式化返回的json数据
		FastJsonConfig FastJsonConfig = new FastJsonConfig();
		FastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat //需要与格式化
		);
//		3. 在convert中添加配置信息
		FastConverter.setFastJsonConfig(FastJsonConfig);
//		4. 将convert添加到converters当中
		converters.add(FastConverter);


	}
}
