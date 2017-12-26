package cn.mazekkkk.product.service;

import cn.mazekkkk.product.dao.common.TblDoctorVerify;

/**
 * 缓存重载
 *
 * @author maze
 * @createTime 17/12/26
 */
public interface CacheReloadService {

    /**
     * 缓存重载根据医师认证id
     *
     * @param id
     * @return
     */
    TblDoctorVerify doctorVerifyCacheReload(Integer id);

    /**
     * 医师认证信息清空重载
     *
     * @param id
     */
    void doctorVerifyCacheEvictReload(Integer id);

}
