package cn.mazekkkk.product.service;

import cn.mazekkkk.product.dao.common.TblDoctorVerify;

/**
 * 医生认证信息获取
 *
 * @author maze
 * @createTime 17/12/21
 */
public interface DoctorVerifyService {
    /**
     * 获取医师认证信息根据主键
     *
     * @param id 主键
     * @return
     */
    TblDoctorVerify getDoctorVerify(Integer id);
}
