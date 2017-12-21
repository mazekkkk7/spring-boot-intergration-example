package cn.mazekkkk.product.dao.mapper;

import cn.mazekkkk.product.dao.common.TblDoctorVerify;

public interface TblDoctorVerifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblDoctorVerify record);

    int insertSelective(TblDoctorVerify record);

    TblDoctorVerify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblDoctorVerify record);

    int updateByPrimaryKey(TblDoctorVerify record);
}