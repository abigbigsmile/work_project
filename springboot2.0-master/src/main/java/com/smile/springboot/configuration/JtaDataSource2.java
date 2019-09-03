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
@MapperScan(basePackages = {"com.smile.springboot.mapper2"}, sqlSessionTemplateRef = "item2SqlSessionTemplate")
public class JtaDataSource2 {

    @Bean(name = "jtaDatasource2", initMethod = "init", destroyMethod = "close")
    public DataSource jtaDatasource2(DBproperties2 dBproperties2) throws SQLException {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dBproperties2.getUrl());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXaDataSource.setPassword(dBproperties2.getPassword());
        mysqlXaDataSource.setUser(dBproperties2.getUsername());
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXaDataSource);
        xaDataSource.setUniqueResourceName("jtaDatasource2");

        xaDataSource.setMinPoolSize(dBproperties2.getMinPoolSize());
        xaDataSource.setMaxPoolSize(dBproperties2.getMaxPoolSize());
        xaDataSource.setMaxLifetime(dBproperties2.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(dBproperties2.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(dBproperties2.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(dBproperties2.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(dBproperties2.getMaxIdleTime());
        return xaDataSource;
    }

    @Bean(name = "item2SqlSessionFactory")
    public SqlSessionFactory item2SqlSessionFactory(@Qualifier("jtaDatasource2") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "item2SqlSessionTemplate")
    public SqlSessionTemplate item2SqlSessionTemplate(
            @Qualifier("item2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
