package cn.mazekkkk.product.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(exclude = DispatcherServletAutoConfiguration.class)
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(value = "cn.mazekkkk.product")
public class MazekkkkApplication {

	public static void main(String[] args) {
		SpringApplication.run(MazekkkkApplication.class, args);
	}

	@Bean(name = "root")
	public ServletRegistrationBean root() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(ControllerConfig.class);
		dispatcherServlet.setApplicationContext(applicationContext);
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/*");
		servletRegistrationBean.setLoadOnStartup(2);
		servletRegistrationBean.setName("root");
		return servletRegistrationBean;
	}

}
