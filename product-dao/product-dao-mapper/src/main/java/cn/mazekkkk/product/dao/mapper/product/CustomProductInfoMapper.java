/**
 * 
 */
package cn.mazekkkk.product.dao.mapper.product;


import cn.mazekkkk.product.common.vo.ProductInfoVo;

import java.util.List;
import java.util.Map;

/**
 * 
 * 自定义产品信息相关  Mapper
 * 
 * @author sean
 *
 */
public interface CustomProductInfoMapper {

	/**
	 * 根据参数查询产品信息
	 * @param model
	 * @return
	 */
	List<ProductInfoVo> getProductInfosByIds(ProductInfoVo model);

    /**
     * 查看套餐产品组件信息
     *
     * @param kitProdId
     * @return 套餐产品ID
     */
    List<Map> getKitComponents(int kitProdId);

    /**
     * 按条件查询
     *
     * @param parameterMap 参数容器
     * @return
     */
    List<Map> getProductInfoByCriteria(Map parameterMap);

    /**
     * 按条件查询所有产品的个数
     *
     * @param parameterMap 参数容器
     * @return
     */
    List<Map> getProductInfoByCriteriaCount(Map parameterMap);

    /**
     * 查询产品所有评论
     * @param parameterMap 参数容器
     * @return
     */
    List<Map> getProductCommentById(Map parameterMap);

    /**
     * 查询产品推荐的产品列表
     * @param parameterMap 参数容器
     * @return
     */
    List<Map> getProductInfoRecByProductId(Map parameterMap);


}
