package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.dao.common.SUser;
import cn.mazekkkk.product.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


/**
 * Created by mazekkkk on 16/6/22.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired  //数据库服务类
    private SUserService suserService;//code7

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //SUser对应数据库中的用户表，是最终存储用户和密码的表，可自定义
        //本例使用SUser中的email作为用户名:
        SUser sUser = suserService.findUserByEmail(userName); //code8
        if (sUser == null) {
            throw new UsernameNotFoundException("UserName " + userName + " not found");
        }
        // SecurityUser实现UserDetails并将SUser的Email映射为username
        return new SecurityUser(sUser); //code9
    }
}


