package cn.mazekkkk.product.security;

import cn.mazekkkk.product.dao.config.ModuleConfig;
import cn.mazekkkk.product.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;

/**
 * Created by mazekkkk on 16/6/22.
 */
@Configuration
@EnableOAuth2Client
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Order(4)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;//code1

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;

    @Autowired
    private ModuleConfig moduleConfig;

    //    主配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问”/”和”/home”
        http.csrf().disable().authorizeRequests().antMatchers(
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
//                .and()
//                .addFilterBefore(BasicAuthenticationFilter.class)
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
                .tokenRepository(tokenRepository())
                .and()
                .httpBasic().disable();//code4

                //csrf防御关闭
                http.csrf().disable();

    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resourceDetails){
        return new OAuth2RestTemplate(resourceDetails,oAuth2ClientContext);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库 //code13
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());//code5
        //不删除凭据，以便记住用户
        auth.eraseCredentials(false);
    }

//    配置类方法
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       //指定密码加密所使用的加密器为passwordEncoder()
//       //需要将密码加密后写入数据库 //code13
//        auth.userDetailsService(this.customUserDetailsService).passwordEncoder(passwordEncoder());
//       //不删除凭据，以便记住用户
//        auth.eraseCredentials(false);
//    }

//    复写父类方法
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    //    加密方法
    @Bean
    public Md5PasswordEncoder passwordEncoder(){
        return new Md5PasswordEncoder();
    }

//    存储token的数据源配置
    @Bean
    public JdbcTokenRepositoryImpl tokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(moduleConfig.primaryDataSource());
        return jdbcTokenRepository;
    }

//    过滤器配置
    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(-100);
        return registrationBean;
    }

    //    Code3----------------------------------------------
//    @Bean
//    public LoginSuccessHandler loginSuccessHandler(){
//        return new LoginSuccessHandler();//code6
//    }



}
