package org.portal.infrastructure.configurationtest;

import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.portal.infrastructure.database.entity._EntityMarker;
import org.portal.infrastructure.database.repository.jpa._JpaRepositoriesMarker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@AllArgsConstructor
@EnableTransactionManagement
@PropertySource({"classpath:database.properties"})
@EnableJpaRepositories (basePackageClasses = _JpaRepositoriesMarker.class)
public class PersistenceJpaConfiguration {
    private final Environment environment;
    @Bean
    @DependsOn ("flyway")
    @SuppressWarnings("unused")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(_EntityMarker.class.getPackageName());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        return dataSource;
    }

    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.format_sql",environment.getProperty("hibernate.format_sql"));
        return properties;
    }
    @Bean
    @SuppressWarnings("unused")
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory entityManagerFactory
    ){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
    @Bean
    @SuppressWarnings("unused")
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    @Bean (initMethod = "migrate")
    @SuppressWarnings("unused")
    public Flyway flyway (){
        ClassicConfiguration configuration = new ClassicConfiguration();
        configuration.setBaselineOnMigrate(true);
        configuration.setLocations(new Location("classpath:flyway/migrations"));
        configuration.setDataSource(dataSource());
        return new Flyway(configuration);
    }
}
