package cn.mazekkkk.product.dao.config;

import cn.mazekkkk.product.redis.service.IRedisService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mazekkkk on 16/1/28.
 */
@Configuration
@EnableAutoConfiguration
@MapperScan("cn.mazekkkk.product.dao.mapper")
@EnableTransactionManagement
public class ModuleConfig implements EnvironmentAware,TransactionManagementConfigurer {

    private RelaxedPropertyResolver propertyResolver;
    private RelaxedPropertyResolver jdbcPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
        this.jdbcPropertyResolver = new RelaxedPropertyResolver(environment,"datasource.primary.");
    }

    /**
     * 数据源管理
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSourceProperties primaryDataSourceProperties(){
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(jdbcPropertyResolver.getProperty("url"));
        dataSourceProperties.setUsername(jdbcPropertyResolver.getProperty("username"));
        dataSourceProperties.setPassword(jdbcPropertyResolver.getProperty("password"));
        dataSourceProperties.setDriverClassName(jdbcPropertyResolver.getProperty("driver-class-name"));
        return dataSourceProperties;
    }

    /**
     * 数据源管理
     * @return
     */
    @Bean
    public DataSource primaryDataSource(){
        DataSourceProperties dataSourceProperties = primaryDataSourceProperties();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * Sqlsession管理数据源
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(primaryDataSource());
        sessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("type-aliases-package"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapper-locations")));
        sessionFactoryBean.setConfigurationProperties(getMyBatisProperties());

        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(getPageHelperProperties());
        sessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});

        return sessionFactoryBean.getObject();
    }

    /**
     * 构建pageHelper配置
     * @return
     */
    public Properties getPageHelperProperties(){
        Properties properties = new Properties();
        properties.setProperty("dialect","mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        return properties;
    }

    /**
     * 构建Mybatis配置
     * @return
     */
    public Properties getMyBatisProperties(){
        Properties properties = new Properties();
        properties.setProperty("cacheEnabled","true");

        return properties;
    }

    /**
     * 数据源管理
     * @return
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(primaryDataSource());
    }

    /**
     * Mybatis通用Mapper配置
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.mazekkkk.product.dao.mapper");
        Properties propertiesMapper = new Properties();
        propertiesMapper.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
        propertiesMapper.setProperty("IDENTITY","SELECT REPLACE(UUID(),'-','')");
        propertiesMapper.setProperty("ORDER","BEFORE");
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }

    /**
     * 注入静态redis服务
     * @param iRedisService redis服务
     * @return
     */
    @Bean
    @Autowired
    public Object setRedisService(IRedisService iRedisService){
        MyBatisRedisCache.setRedisService(iRedisService);
        return null;
    }

}
