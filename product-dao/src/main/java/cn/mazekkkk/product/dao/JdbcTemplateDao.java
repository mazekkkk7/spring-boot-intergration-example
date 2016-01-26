package cn.mazekkkk.product.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by mazekkkk on 16/1/21.
 */
@Repository
public class JdbcTemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取所有地址
     * @return
     */
    public List<Map<String,Object>> selectAllAddress(){
        List<Map<String,Object>> resultList =jdbcTemplate.queryForList("SELECT * FROM xnc_address");
        return resultList;
    }

}
