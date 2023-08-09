package com.jbground.community.config.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jbground.community.interceptor.LayoutInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.nio.file.Paths;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    //D:/jsjeong/community/src/main/resources/static - java 파일 있는 곳 절대경로
    private String path = String.valueOf(Paths.get(System.getProperty("user.dir"), "/src/main/resources/static"));


    @Bean
    public LayoutInterceptor layoutInterceptor(){
        return new LayoutInterceptor();
    }

    @Bean
    public ObjectMapper objectMapper() {

        ObjectMapper objectMapper = new ObjectMapper();
        // no timestamp
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        // ignore unknown json properties
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // allow empty string to null
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        return objectMapper;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(layoutInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/test/test");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**/**").addResourceLocations("classpath:/static/"); //산출물 기준 경로
        // registry.addResourceHandler("/**/**").addResourceLocations("file:" + path + "/"); //resources 절대 경로
    }

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setPrefix("/templates/");
        classLoaderTemplateResolver.setSuffix(".html");
        classLoaderTemplateResolver.setCacheable(false);
        classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML);
        classLoaderTemplateResolver.setCharacterEncoding("UTF-8");
        classLoaderTemplateResolver.setUseDecoupledLogic(false);

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setEnableSpringELCompiler(false);
//        templateEngine.setAdditionalDialects(
//                new HashSet<IDialect>(
//                        Arrays.<IDialect>asList(
//                                new LayoutDialect(new GroupingStrategy())
//
//                        )
//                )
//        );
        templateEngine.setTemplateResolver(classLoaderTemplateResolver);

        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setViewNames(new String[]{"thymeleaf/**"});
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        registry.viewResolver(thymeleafViewResolver);

        registry.enableContentNegotiation(new MappingJackson2JsonView(objectMapper()));
    }
}
