/**
 * 
 */
package cn.mazekkkk.product.dao.mapper.user;


import cn.mazekkkk.product.common.vo.UserAddressVo;

import java.util.List;
import java.util.Map;




/**
 * 会员收货地址
 * 
 * @author sean
 *
 */
public interface CustomUserAddressMapper {

	/**
	 * 根据会员ID查询会员地址列表
	 * 
	 * @param vo
	 * @return
	 */
	List<UserAddressVo> getUserAddressList(UserAddressVo vo);
	
	/**
	 * 根据参数相关收货地址信息
	* @Title: selectUserAddress
	* @Description: TODO
	* @param vo
	* @return   
	* @return List<Map>    返回类型
	* @throws
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectUserAddress(UserAddressVo vo);
	
}
