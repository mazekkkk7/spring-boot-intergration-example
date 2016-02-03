package cn.mazekkkk.product.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
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

import javax.sql.DataSource;

/**
 * Created by mazekkkk on 16/1/28.
 */
@Configuration
@MapperScan("cn.mazekkkk.product.dao.mapper")
@EnableTransactionManagement
public class ModuleConfig implements EnvironmentAware,TransactionManagementConfigurer {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment,"mybatis.");
    }

    /**
     * 数据源管理
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource(){
        return DataSourceBuilder.create().build();
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
        sessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("typeAliasesPackage"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapperLocations")));
        return sessionFactoryBean.getObject();
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
}
