package me.defian;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
@ComponentScan
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
//
//    @Bean
//    public HandlerMapping handlerMapping(){
//        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
//        handlerMapping.setInterceptors();
//        handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return handlerMapping;
//    }

//
//    @Bean
//    public HandlerAdapter handlerAdapter(){
//        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
//        handlerAdapter.setArgumentResolvers();
//    }

//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/",".jsp");
    }
}




