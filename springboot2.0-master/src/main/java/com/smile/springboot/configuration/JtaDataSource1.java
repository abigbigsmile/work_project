package com.smile.springboot.configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = {"com.smile.springboot.mapper"},sqlSessionTemplateRef = "item1SqlSessionTemplate")
public class JtaDataSource1 {

   @Bean(name = "jtaDatasource1", initMethod = "init", destroyMethod = "close")
   public DataSource jtaDatasource1(DBProperties1 dbProperties1) throws SQLException {
       MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
       mysqlXaDataSource.setUrl(dbProperties1.getUrl());
       mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
       mysqlXaDataSource.setPassword(dbProperties1.getPassword());
       mysqlXaDataSource.setUser(dbProperties1.getUsername());
       mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

       //配置总的事务管理
       AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
       xaDataSource.setXaDataSource(mysqlXaDataSource);
       xaDataSource.setUniqueResourceName("jtaDatasource1");

       xaDataSource.setMinPoolSize(dbProperties1.getMinPoolSize());
       xaDataSource.setMaxPoolSize(dbProperties1.getMaxPoolSize());
       xaDataSource.setMaxLifetime(dbProperties1.getMaxLifetime());
       xaDataSource.setBorrowConnectionTimeout(dbProperties1.getBorrowConnectionTimeout());
       xaDataSource.setLoginTimeout(dbProperties1.getLoginTimeout());
       xaDataSource.setMaintenanceInterval(dbProperties1.getMaintenanceInterval());
       xaDataSource.setMaxIdleTime(dbProperties1.getMaxIdleTime());
       return xaDataSource;
   }

    @Bean(name = "item1SqlSessionFactory")
    public SqlSessionFactory item1SqlSessionFactory(@Qualifier("jtaDatasource1") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "item1SqlSessionTemplate")
    public SqlSessionTemplate item1SqlSessionTemplate(
            @Qualifier("item1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
