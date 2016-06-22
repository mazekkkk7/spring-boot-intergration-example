package cn.mazekkkk.product.security;

import cn.mazekkkk.product.dao.config.ModuleConfig;
import cn.mazekkkk.product.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

/**
 * Created by mazekkkk on 16/6/22.
 */
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private CustomUserDetailsService customUserDetailsService;//code1

    @Autowired
    private ModuleConfig moduleConfig;//code2


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问”/”和”/home”
        http.authorizeRequests().antMatchers(
                "/security/",
                "/security/home",
                "/css/**",
                "/js/**",
                "/images/**").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //指定登录页是”/login”
                .loginPage("/security/login")
                .permitAll()
                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .and()
                .logout()
                //退出登录后的默认网址是”/home”
                .logoutSuccessUrl("/security/home")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                //登录后记住用户，下次自动登录
                //数据库中必须存在名为persistent_logins的表
                //建表语句见code15
                .rememberMe()
                .tokenValiditySeconds(1209600)
                //指定记住登录信息所使用的数据源
                .tokenRepository(tokenRepository());//code4

                //csrf防御关闭
                http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库 //code13
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//code5
        //不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }

    // Code5----------------------------------------------
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

    // Code4----------------------------------------------
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(moduleConfig.primaryDataSource());
        return jdbcTokenRepository;
    }

    // Code3----------------------------------------------
//    @Bean
//    public LoginSuccessHandler loginSuccessHandler(){
//        return new LoginSuccessHandler();//code6
//    }
}
