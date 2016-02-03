package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.common.XncAddressExample;
import cn.mazekkkk.product.dao.mapper.XncAddressMapper;
import cn.mazekkkk.product.service.XncAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mazekkkk on 16/1/26.
 */
@Service("xncAddressService")
@Transactional
public class XncAddressServiceImpl implements XncAddressService {

    @Autowired
    private XncAddressMapper xncAddressMapper;

    /**
     * 获取所有地址
     * @return
     */
    @Override
    public Object getAllAddress() {
        XncAddressExample xncAddressExample = new XncAddressExample();
        return xncAddressMapper.selectByExample(xncAddressExample);
    }


}
