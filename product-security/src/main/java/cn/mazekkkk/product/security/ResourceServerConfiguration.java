package cn.mazekkkk.product.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").authenticated();
    }


    //    @Autowired
//    private ModuleConfig moduleConfig;
//
//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository(){
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(moduleConfig.primaryDataSource());
//        return jdbcTokenRepository;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //允许所有用户访问”/”和”/home”
//        http.authorizeRequests().antMatchers(
//                "/security/",
//                "/security/home",
//                "/css/**",
//                "/js/**",
//                "/images/**").permitAll()
//                //其他地址的访问均需验证权限
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //指定登录页是”/login”
//                .loginPage("/security/login")
//                .permitAll()
////                .and()
////                .addFilterBefore(BasicAuthenticationFilter.class)
//                //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
//                .and()
//                .logout()
//                //退出登录后的默认网址是”/home”
//                .logoutSuccessUrl("/security/home")
//                .permitAll()
//                .invalidateHttpSession(true)
//                .and()
//                //登录后记住用户，下次自动登录
//                //数据库中必须存在名为persistent_logins的表
//                //建表语句见code15
//                .rememberMe()
//                .tokenValiditySeconds(1209600)
//                //指定记住登录信息所使用的数据源
//                .tokenRepository(tokenRepository());//code4
//
//        //csrf防御关闭
//        http.csrf().disable();
//
//    }

}