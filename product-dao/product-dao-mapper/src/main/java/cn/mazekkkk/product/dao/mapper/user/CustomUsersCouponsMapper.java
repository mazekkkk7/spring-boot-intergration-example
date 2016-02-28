/**
 * 
 */
package cn.mazekkkk.product.dao.mapper.user;


import cn.mazekkkk.product.common.vo.UserCouponsVo;

import java.util.List;
import java.util.Map;


/**
 * 
 * 自定义会员优惠券接口
 * 
 * 
 * @author sean
 *
 */
public interface CustomUsersCouponsMapper {
 
	
	/**
	 * 根据参数查询会员优惠券信息
	 * 
	 * @param vo
	 * @return
	 */
	List<UserCouponsVo> getUserCouponsList(UserCouponsVo vo);
	
	/**
	 * 用户信息查询用户优惠券
	* @Title: getCouponsByUser
	* @Description: TODO
	* @param vo
	* @return   
	* @return List<Map>    返回类型
	* @throws
	 */
	List<Map> getCouponsByUser(UserCouponsVo vo);
}
