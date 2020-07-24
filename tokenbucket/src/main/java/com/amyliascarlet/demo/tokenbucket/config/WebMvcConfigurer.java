package com.amyliascarlet.demo.tokenbucket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

   @Override
   public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(tokenBucketInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public TokenBucketInterceptor tokenBucketInterceptor()
    {
        return new TokenBucketInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*")
                .maxAge(3600);
    }


}
