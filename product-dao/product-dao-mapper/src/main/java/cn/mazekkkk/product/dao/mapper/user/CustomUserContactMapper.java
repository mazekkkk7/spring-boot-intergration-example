/** 

 * @Project : platform-dao-mapper

 * @Title : CustomUserContactMapper.java

 * @Package cn.cloudmirror.platform.dao.mapper.user

 * @Description : TODO

 * @author wangjianwei

 * @date 2015-11-2 上午10:54:11

 * @Copyright : 2015 www.cloudmirror.cn Inc. All rights reserved.

 * @version V1.0 

 */
package cn.mazekkkk.product.dao.mapper.user;


import cn.mazekkkk.product.common.vo.UserContactVo;

import java.util.List;



/**
 * 
 * 会员联系方式
 * 
 * @ClassName CustomUserContactMapper

 * @Description TODO

 * @author wangjianwei

 * @date 2015-11-2


 */
public interface CustomUserContactMapper {

	/**
	 * 查询会员联系地址信息
	 * 
	 * @Title: selectUserContact
	 * @Description: TODO
	 * @param vo
	 * @return   
	 * @return List<UserContactVo>    返回类型
	 * @throws
	 */
	public List<UserContactVo>  selectUserContact(UserContactVo vo);
}
