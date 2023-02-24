package io.reflectoring.Music.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class TokenValidatorInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    TokenValidatorInterceptor validatorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor((HandlerInterceptor) validatorInterceptor).addPathPatterns("/**").excludePathPatterns("/v2/api-docs",
                "/configuration/ui", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html", "/webjars/**",
                "/csrf", "/","/error");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * This is used to refer the value to the libray Bean for handling the data */

    @Bean
    @ConfigurationProperties(prefix = "authveri")
    public ConfigurationKeeper configurationKeeper() {
        return new ConfigurationKeeper();
    }

}

