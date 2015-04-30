/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rzd.vivc.documentexamination.repository;

import javax.sql.DataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Настройки для работы с БД
 *
 * @author VVolgina
 */
@Configuration
@EnableJpaRepositories(basePackages = "rzd.vivc.documentexamination.repository")
@EnableTransactionManagement
@Import({TransactionsConfig.class, RepositoryAspectsConfig.class})
public class SpringDateConfig {

    @Bean
    //настройка источника данных
    public DataSource dataSource() {
        //встроенная БД H2
        EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
        edb.setType(EmbeddedDatabaseType.H2);
        //расположение скриптов для создания БД и ее заполнения
        edb.addScript("rzd/vivc/documentexamination/testdb/schema.sql");
        edb.addScript("rzd/vivc/documentexamination/testdb/test-data.sql");
        //создать БД
        EmbeddedDatabase embeddedDatabase = edb.build();
        return embeddedDatabase;
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
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return adapter;
    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    
}
