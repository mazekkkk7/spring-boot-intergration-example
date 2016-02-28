package cn.mazekkkk.product.dao.mapper.machine;/* (C) Copyright 2015-2017, RGI Technology Inc.
 * All rights reserved.
 * 
 * Created at : 2015/10/28 11:55
 * User: yonghui.feng
 */


import cn.mazekkkk.product.dao.common.MachineRfidLossRecord;
import cn.mazekkkk.product.dao.common.MachineRfidShelveRecord;

import java.util.List;
import java.util.Map;

public interface CustomMachineMapper {
    /**
     * 获取终端机所有货道销售商品
     *
     * @param map 终端机相关参数
     * @return 该终端机所有货道销售商品
     */
    List<Map> getMachineSaleProducts(Map map);

    Map getMachineProByProductId(Map map);

    List<Map<String, Object>> getKitComponents(Map map);

    int insertRfidShelveRecord(List<MachineRfidShelveRecord> list);

    int insertRfidLossRecord(List<MachineRfidLossRecord> list);

    List<MachineRfidShelveRecord> getNowInventory(Long shelveId);
}
