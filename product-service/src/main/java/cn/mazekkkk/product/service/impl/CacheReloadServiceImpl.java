package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.dao.common.TblDoctorVerify;
import cn.mazekkkk.product.dao.mapper.TblDoctorVerifyMapper;
import cn.mazekkkk.product.service.CacheReloadService;
import cn.mazekkkk.product.service.DoctorVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 换粗重载实现类
 *
 * @author maze
 * @createTime 17/12/26
 */
@Service
public class CacheReloadServiceImpl implements CacheReloadService {

    @Autowired
    private DoctorVerifyService doctorVerifyService;
    @Autowired
    private TblDoctorVerifyMapper tblDoctorVerifyMapper;

    /**
     * 缓存重载根据医师认证id
     *
     * @param id
     * @return
     */
    @Cacheable(key = "'doctorVerify_'+#id", value = "doctorVerifyCache")
    @Override
    public TblDoctorVerify doctorVerifyCache(Integer id) {
        return tblDoctorVerifyMapper.selectByPrimaryKey(id);
    }

    /**
     * 医师认证信息清空重载
     *
     * @param id
     */
    @CachePut(key = "'doctorVerify_'+#id", value = "doctorVerifyCache")
    @Override
    public void doctorVerifyCacheReload(Integer id) {
        doctorVerifyService.getDoctorVerify(id);
    }
}
