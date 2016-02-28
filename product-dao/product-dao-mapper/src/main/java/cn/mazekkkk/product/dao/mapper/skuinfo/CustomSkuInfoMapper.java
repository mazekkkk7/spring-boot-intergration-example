package cn.mazekkkk.product.dao.mapper.skuinfo;

import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/1/6.
 */
public interface CustomSkuInfoMapper {

    List<Map> getSkuPropByParameterMap(Map parameterMap);

    Map getSkuIdByPropValudIds(Map parameterMap);

}
