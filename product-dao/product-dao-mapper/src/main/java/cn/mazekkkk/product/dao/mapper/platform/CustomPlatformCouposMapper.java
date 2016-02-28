/** 

 * @Project : platform-dao-mapper

 * @Title : CustomPlatformCouposMapper.java

 * @Package cn.cloudmirror.platform.dao.mapper.platform

 * @Description : TODO

 * @author wangjianwei

 * @date 2015-10-29 下午3:29:57

 * @Copyright : 2015 www.cloudmirror.cn Inc. All rights reserved.

 * @version V1.0 

 */
package cn.mazekkkk.product.dao.mapper.platform;


import cn.mazekkkk.product.common.vo.PlatformCouponVo;

import java.util.List;
import java.util.Map;



/**
 * 
 * 自定义优惠券信息
 * 
 * @ClassName CustomPlatformCouposMapper

 * @Description TODO

 * @author wangjianwei

 * @date 2015-10-29


 */
public interface CustomPlatformCouposMapper {
	
	/**
	 * 根据平台Id 和优惠券类型查询优惠券信息
	 * 
	* @Title: getCoupons
	* @Description: TODO
	* @param coupon
	* @return   
	* @return PlatformCouponVo    返回类型
	* @throws
	 */
	List<PlatformCouponVo> getCoupons(PlatformCouponVo coupon);

	
	/**
	 * 根据相关参数查询优惠券信息
	* @Title: selectUserCoupons
	* @Description: TODO
	* @param vo
	* @return   
	* @return List<UserCouponsVo>    返回类型
	* @throws
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectUserCoupons(PlatformCouponVo vo);
	
	
	/**
	 * 根据相关参数查询终端机优惠券信息
	* @Title: selectUserCoupons
	* @Description: TODO
	* @param vo
	* @return   
	* @return List<UserCouponsVo>    返回类型
	* @throws
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectMachineCoupons(PlatformCouponVo vo);
}
