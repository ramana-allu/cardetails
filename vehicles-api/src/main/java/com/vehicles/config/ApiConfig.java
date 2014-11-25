package com.vehicles.config;


import javax.inject.Inject;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.env.Environment;

import com.vehicles.lookup.repository.LookupRepository;

/**
 * ProductSetupAPIConfig is for defining all Beans related to API Project
 *
 * @author uday.reddy
 */

@ComponentScan(basePackages = { "com.vehicles" })
@Configuration
@Import(RepositoryConfig.class)

public class ApiConfig {

	
    @Inject

    private Environment env;



	    /**

	     * Data source : This bean is responsible for getting the details

	     * <p/>

	     * from jndi and configuring a dataSource.

	     *

	     * @param jndiName JNDI name

	     * @return the jndi object factory bean

	     */

	    private JndiObjectFactoryBean dataSourceHelper(String jndiName){

	        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();

	        jndiObjectFactoryBean.setJndiName(jndiName);

	        jndiObjectFactoryBean.setResourceRef(true);

	        return jndiObjectFactoryBean;

	    }



	    @Bean(name = "dataSource")

	    public JndiObjectFactoryBean dataSource() {

	        return dataSourceHelper("jdbc/cardetails");

	    }




//
//	    @Bean
//
//	    public JndiObjectFactoryBean stagingDataSource() {
//
//	        return dataSourceHelper("jdbc/DELTAVIEWER_DEV");
//
//	    }
//


	    /**

	     * Sql session factory : This bean is used for creating a instance

	     * <p/>

	     * for SqlSessionFactory with datasource configured to it.

	     * @param sqlMapProperty property name which defines the location of the mapper config file

	     * @param dataSource Data source to be used

	     *

	     * @return the sql session factory

	     */

	    private SqlSessionFactory sqlSessionFactoryHelper(String sqlMapProperty, DataSource dataSource){

	        String sqlMapLocation = getProperty(sqlMapProperty);

	        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

	        sqlSessionFactory.setDataSource(dataSource);

	        sqlSessionFactory.setConfigLocation(new ClassPathResource(sqlMapLocation));



	        try {

	            return sqlSessionFactory.getObject();

	        } catch (Exception e) {
e.printStackTrace();
//	            LOGGER.error("Failed to initialize sqlSessionFactory", e);

	        }

	        return null;

	    }



	    @Bean

	    public SqlSessionFactory sqlSessionFactory() {

	        return sqlSessionFactoryHelper("sqlmap.location", (DataSource)dataSource().getObject());

	    }


	    protected String getProperty(String key, String defaultValue) {

	        String property = getProperty(key);

	        if (property == null) {

	            return defaultValue;

	        }

	        return property;

	    }



	    protected String getProperty(String key) {

	        String property = "mybatis/sqlmap-config.xml";

	        if (property == null || property.trim().length() == 0) {

//	            LOGGER.error("property with key = " + key + " = " + property);

	        }

	        return property != null ? property.trim() : null;

	    }


	    @Bean

	    public LookupRepository lookupRepository() {

	        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());

	        return sessionTemplate.getMapper(LookupRepository.class);

	    }

}
