package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.common.enums.BaseResult;
import cn.mazekkkk.product.common.result.BaseResultMap;
import cn.mazekkkk.product.dao.common.SUser;
import cn.mazekkkk.product.dao.common.SUserExample;
import cn.mazekkkk.product.dao.mapper.SUserMapper;
import cn.mazekkkk.product.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/6/21.
 */
@Service("sUserService")
public class SUserServiceImpl implements SUserService {

    @Autowired
    private SUserMapper sUserMapper;

    private String result = BaseResult.SUCCESS.toString();

    private String message = "";

    private String errorMessage = "";

    private Object data;

    @Override
    public Map<String, Object> findAllComplex() {
        return null;
    }

    @Override
    public Map<String, Object> createComplex(SUser user) {
        return null;
    }

    @Override
    public Map<String, Object> findUserByIdComplex(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> loginComplex(String email, String password) {
        return null;
    }

    @Override
    public Map<String, Object> updateComplex(SUser user) {
        return null;
    }

    @Override
    public Map<String, Object> deleteUserComplex(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> findUserByEmailComplex(String email) {
        return null;
    }

    @Override
    public List<SUser> findAll() {

//        data = sUserMapper.selectByExample(new SUserExample());
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return new ArrayList<SUser>();

    }

    @Override
    public Integer create(SUser user) {

//        data = sUserMapper.insert(new SUser());
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return 1;

    }

    @Override
    public SUser findUserById(Integer id) {

//        data = sUserMapper.selectByPrimaryKey(id);
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return new SUser();

    }

    @Override
    public SUser login(String email, String password) {

        SUserExample sUserExample = new SUserExample();
        sUserExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<SUser> sUserList = sUserMapper.selectByExample(sUserExample);
        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        if (sUserList.size()>0){
            message = "登录成功";
            return sUserList.get(0);
        }else{
            result = BaseResult.FAIL.toString();
            errorMessage = "登录失败";
            return new SUser();
        }

    }

    @Override
    public Integer update(SUser user) {

//        Integer row = sUserMapper.updateByPrimaryKey(user);
//
//        if(row>0){
//            message = "更新成功";
//        }else{
//            result = BaseResult.FAIL.toString();
//            errorMessage = "更新失败";
//        }
//
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return 1;
    }

    @Override
    public Integer deleteUser(Integer id) {

//        Integer row = sUserMapper.deleteByPrimaryKey(id);
//
//        if(row>0){
//            message = "删除成功";
//        }else{
//            result = BaseResult.FAIL.toString();
//            message = "删除失败";
//        }
//
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return 1;
    }

    @Override
    public SUser findUserByEmail(String email) {

        SUserExample sUserExample = new SUserExample();
        sUserExample.createCriteria().andEmailEqualTo(email);
        List<SUser> resultUser = sUserMapper.selectByExample(sUserExample);
//        data =  sUserMapper.selectByExample(sUserExample);
//        BaseResultMap baseResultMap =  new BaseResultMap(result,message,errorMessage,data);

        return resultUser.size() == 0 ? null : resultUser.get(0);

    }

}
