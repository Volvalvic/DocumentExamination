/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.configuration;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Настройки для работы с БД MySQL
 *
 * @author VVolgina
 */
@Configuration
@EnableJpaRepositories(basePackages = "rzd.vivc.documentexamination.repository")
@Import({TransactionsConfig.class, RepositoryAspectsConfig.class})
public class SpringDateConfigMySQL {

    @Bean
    //настройка источника данных
    public DataSource dataSource() {
        //MySQL
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //расположение БД
        ds.setUrl("jdbc:mysql://localhost:3306/dateexamination");
       ds.setUsername("root");
        /* ds.setUsername("exam");
        ds.setPassword("exam68");*/
        //пул
        ds.setInitialSize(5);
        ds.setMaxIdle(5);
        ds.setMaxTotal(15);

        return ds;
    }

    /**
     * фабрика сессий
     *
     * @param dataSource источник данных
     * @param jpaVendorAdapter в нашем случае хибернейт
     * @return фабрика сессий
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPersistenceUnitName("documentexamination");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        //Где расположены классы сущностей
        emf.setPackagesToScan("rzd.vivc.documentexamination.model.dto");
        return emf;
    }

    /**
     * Настройки хибернейта
     *
     * @return Адаптер хибернейта
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
}
