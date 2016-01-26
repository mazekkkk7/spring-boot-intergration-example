package cn.mazekkkk.product.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
//@EnableWebMvc
@EnableScheduling
//@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = { "cn.mazekkkk.product" })
public class MazekkkkApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MazekkkkApplication.class);
		app.run(args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "datasource.primary")
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}

}
