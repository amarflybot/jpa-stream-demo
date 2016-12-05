package com.amar;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by amarendra on 5/12/16.
 */
@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Autowired
    @Bean
    public PlatformTransactionManager txManager(SessionFactory sf) {
        HibernateTransactionManager mgr = new HibernateTransactionManager(sf);
        mgr.setAllowResultAccessAfterCompletion(true);
        return mgr;
    }

}
