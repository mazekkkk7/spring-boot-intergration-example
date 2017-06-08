package cn.mazekkkk.product.service;

import cn.mazekkkk.product.dao.common.SUser;

import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/6/21.
 */
public interface SUserService {
    Map<String,Object> findAllComplex();

    Map<String,Object> createComplex(SUser user);

    Map<String,Object> findUserByIdComplex(Integer id);

    Map<String,Object> loginComplex(String email, String password);

    Map<String,Object> updateComplex(SUser user);

    Map<String,Object> deleteUserComplex(Integer id);

    Map<String,Object> findUserByEmailComplex(String email);

    List<SUser> findAll();

    Integer create(SUser user);

    SUser findUserById(Integer id);

    SUser login(String email, String password);

    Integer update(SUser user);

    Integer deleteUser(Integer id);

    SUser findUserByEmail(String email);

}
