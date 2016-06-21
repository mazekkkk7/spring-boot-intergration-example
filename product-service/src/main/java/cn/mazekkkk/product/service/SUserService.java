package cn.mazekkkk.product.service;

import cn.mazekkkk.product.dao.common.SUser;

import java.util.Map;

/**
 * Created by mazekkkk on 16/6/21.
 */
public interface SUserService {
    Map<String,Object> findAll();

    Map<String,Object> create(SUser user);

    Map<String,Object> findUserById(Integer id);

    Map<String,Object> login(String email, String password);

    Map<String,Object> update(SUser user);

    Map<String,Object> deleteUser(Integer id);

    Map<String,Object> findUserByEmail(String email);
}
