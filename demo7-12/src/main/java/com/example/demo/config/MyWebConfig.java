package com.example.demo.config;

import com.example.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebConfig extends WebMvcConfigurationSupport {

//    @Value("${web.upload.path}")
//    private String uploadPath;



    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceLocations 指的是文件放置的目录，addResoureHandler 指的是对外暴露的访问路径
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        //    /webjars/** 映射到 classpath:/META-INF/resources/webjars/
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     *
        Spring Boot 对静态资源映射提供了默认配置
        Spring Boot 默认将  /**  所有访问映射到以下目录：
        classpath:/static
        classpath:/public
        classpath:/resources
        classpath:/META-INF/resources
        优先级顺序为：META-INF/resources > resources > static > public
        Spring Boot 默认会挨个从 public resources static 里面找是否存在相应的资源，如果有则直接返回。
     */


    @Bean
    public MyInterceptor myInterceptor() {
        //在Spring添加拦截器之前先自己创建一下这个Spring Bean，这样就能在Spring映射这个拦截器前，把拦截器中的依赖注入给完成了。
        return new MyInterceptor();
    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 把拦截器加载进来 . excludePathPatterns 用户排除拦截
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**").
                excludePathPatterns("/user/loginUser","/css/**","/js/**","/img/**",
                        "/index.html","*.svg","*.ico","/webjars/**");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        // cookie 跨域
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true).maxAge(3600);
        super.addCorsMappings(registry);
    }

    // WebMvcConfigurationSupport 与WebMvcConfigurerAdapter 都可以配置MVC,
    // WebMvcConfigurationSupport 支持的自定义的配置更多更全，
    // WebMvcConfigurerAdapter有的WebMvcConfigurationSupport 都有.
    // WebMvcConfigurerAdapter 已过时

}
