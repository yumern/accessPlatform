package com.zzu.hezhifeng.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据库配置
 */
@Configuration
public class DatasourceConfig {
    /**
     * mybatis配置说明：
     *  1、驼峰命名
     *  2、使用自动生成的key作为id
     */
    private static final String configPath = "classpath:/mybatis/mybatis-config.xml";
    /**
     * mapper文件的存放地址
     */
    private static final String mapperPath = "classpath:/mybatis/mappers/**.xml";

    /**
     * 数据库连接信息
     */
    @Value("${ds.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${ds.datasource.ur}")
    private String url;
    @Value("${ds.datasource.username}")
    private String userName;
    @Value("${ds.datasource.password}")
    private String password;

    /**
     * 数据库配置，默认对象名称为dataSource
     * @return
     */
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.password("qaz987123");
        dataSourceBuilder.username("root");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/access_platform_db?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true");
        DataSource dataSource = dataSourceBuilder.build();
        return dataSource;
    }

    /**
     * 数据库的事务管理
     * @param dataSource
     * @return
     */
    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * SqlSessionFactory
     * 默认生成的对象名称为sqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource(configPath);
        sqlSessionFactoryBean.setConfigLocation(resource);
        Resource[] resources = resourcePatternResolver.getResources(mapperPath);
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置mapper扫描器
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.zzu.hezhifeng.dao");
        return mapperScannerConfigurer;
    }
}
