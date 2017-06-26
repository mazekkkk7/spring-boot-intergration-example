package cn.mazekkkk.product.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by maze on 17/6/23.
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 添加新的拦截器
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SignInterceptor());
        interceptorRegistration.addPathPatterns("/api/**");
    }
}
