package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.dao.JdbcTemplateDao;
import cn.mazekkkk.product.dao.mapper.XncAddressMapper;
import cn.mazekkkk.product.service.XncAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/1/26.
 */
@Service("xncAddressService")
@Transactional("txName")
public class XncAddressServiceImpl implements XncAddressService {

    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    @Autowired
    private XncAddressMapper xncAddressMapper;

    /**
     * 获取所有地址
     * @return
     */
    @Override
    public List<Map<String, Object>> getAllAddress() {
//        return jdbcTemplateDao.selectAllAddress();
        return xncAddressMapper.selectXncAddress();
    }


}
