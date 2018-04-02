package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.dao.common.TblDoctorVerify;
import cn.mazekkkk.product.dao.mapper.TblDoctorVerifyMapper;
import cn.mazekkkk.product.service.CacheReloadService;
import cn.mazekkkk.product.service.DoctorVerifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 医师认证信息实现类
 *
 * @author maze
 * @createTime 17/12/21
 */
@Service
public class DoctorVerifyServiceImpl implements DoctorVerifyService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TblDoctorVerifyMapper tblDoctorVerifyMapper;
    @Autowired
    private CacheReloadService cacheReloadServiceImpl;

    /**
     * 获取医师认证信息根据主键
     *
     * @param id 主键
     * @return
     */
    @Cacheable(key = "'doctorVerify_'+#id",value = "doctorVerifyCache")
    @Override
    public TblDoctorVerify getDoctorVerify(Integer id) {
        logger.info(id.toString());
        return tblDoctorVerifyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDoctorVerify(TblDoctorVerify tblDoctorVerify) {
        tblDoctorVerifyMapper.updateByPrimaryKeySelective(tblDoctorVerify);
        cacheReloadServiceImpl.doctorVerifyCache(tblDoctorVerify.getId());
    }
}
