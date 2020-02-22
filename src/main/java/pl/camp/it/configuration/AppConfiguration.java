package pl.camp.it.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();

        /*
        org.hibernate.cfg.Configuration c = new org.hibernate.cfg.Configuration();
        c = c.configure();
        SessionFactory sessionFactory = c.buildSessionFactory();
        return sessionFactory;
        */
    }
}
