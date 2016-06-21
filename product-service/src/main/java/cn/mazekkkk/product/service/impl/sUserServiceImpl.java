package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.common.BaseResultMap;
import cn.mazekkkk.product.common.enums.BaseResult;
import cn.mazekkkk.product.dao.common.SUser;
import cn.mazekkkk.product.dao.common.SUserExample;
import cn.mazekkkk.product.dao.mapper.SUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/6/21.
 */
@Service("suserService")
public class sUserServiceImpl {

    @Autowired
    private SUserMapper sUserMapper;

    private String result = BaseResult.SUCCESS.toString();

    private String message = "";

    private String errorMessage = "";

    private Object data;

    public Map<String,Object> findAll() {

        data = sUserMapper.selectByExample(new SUserExample());
        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();

    }

    public Map<String,Object> create(SUser user) {

        data = sUserMapper.insert(new SUser());
        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();

    }

    public Map<String,Object> findUserById(Integer id) {

        data = sUserMapper.selectByPrimaryKey(id);
        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();

    }

    public Map<String,Object> login(String email, String password) {

        SUserExample sUserExample = new SUserExample();
        sUserExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<SUser> sUserList = sUserMapper.selectByExample(sUserExample);
        if (sUserList.size()>0){
            message = "登录成功";
        }else{
            result = BaseResult.FAIL.toString();
            errorMessage = "登录失败";
        }

        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();
    }

    public Map<String,Object> update(SUser user) {

        Integer row = sUserMapper.updateByPrimaryKey(user);

        if(row>0){
            message = "更新成功";
        }else{
            result = BaseResult.FAIL.toString();
            errorMessage = "更新失败";
        }

        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();
    }

    public Map<String,Object> deleteUser(Integer id) {

        Integer row = sUserMapper.deleteByPrimaryKey(id);

        if(row>0){
            message = "删除成功";
        }else{
            result = BaseResult.FAIL.toString();
            message = "删除失败";
        }

        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();
    }

    public Map<String,Object> findUserByEmail(String email) {

        SUserExample sUserExample = new SUserExample();
        sUserExample.createCriteria().andEmailEqualTo(email);
        data =  sUserMapper.selectByExample(sUserExample);
        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return baseResultMap.getResultMap();

    }

}
