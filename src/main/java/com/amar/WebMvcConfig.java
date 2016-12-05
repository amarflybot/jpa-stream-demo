package com.amar;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by amarendra on 5/12/16.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private OpenSessionInViewInterceptor osivInterceptor;

    @Autowired
    @Bean
    public OpenSessionInViewInterceptor osivInterceptor(SessionFactory sf) {
        OpenSessionInViewInterceptor osiv = new OpenSessionInViewInterceptor();
        osiv.setSessionFactory(sf);
        return osiv;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(osivInterceptor);
    }

}
