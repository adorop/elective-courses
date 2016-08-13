package by.it.academy.adorop.service.config;

import by.it.academy.adorop.dao.config.PersistenceConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.it.academy.adorop.service")
@Import(PersistenceConfig.class)
@EnableAspectJAutoProxy
public class  ServiceConfig {

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    @Profile("debug")
    public static BeanPostProcessor profilingBeanPostProcessor() {
        return new ProfilingBeanPostProcessor();
    }
}
