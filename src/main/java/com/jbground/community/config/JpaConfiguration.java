package com.jbground.community.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "jpaEntityManagerFactory"
        , transactionManagerRef = "transactionManager"
        , basePackages = {}
)
public class JpaConfiguration {

    @Primary
    @Bean(name = "jpaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jpaEntityManagerFactory(EntityManagerFactoryBuilder builder
            , @Qualifier("dataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("").build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public JpaTransactionManager transactionManager(@Qualifier("jpaEntityManagerFactory") LocalContainerEntityManagerFactoryBean factoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(factoryBean.getObject());
        return transactionManager;
    }


    //하이버네이트를 연동하는 방법
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        return hibernateJpaVendorAdapter;
    }

   /* public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setPackagesToScan("kr.go.culture.batch.model");
        entityManagerFactoryBean.setPersistenceUnitName("oracle");
        entityManagerFactoryBean.setJpaProperties(propertySet());

        logger.info("Create oracle entityManaberFactoryBean.");
        return entityManagerFactoryBean;
    }*/

   /* public PlatformTransactionManager oracleTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(oracleEntityManagerFactory().getObject());
        jpaTransactionManager.setDataSource(hikari_oracle);

        logger.info("Create oracle PlatformTransactionManager.");
        return jpaTransactionManager;
    }*/
}
