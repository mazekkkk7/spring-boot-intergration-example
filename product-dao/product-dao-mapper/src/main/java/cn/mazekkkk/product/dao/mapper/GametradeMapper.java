package cn.mazekkkk.product.dao.mapper;

import cn.mazekkkk.product.dao.common.Gametrade;
import cn.mazekkkk.product.dao.common.GametradeExample;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GametradeMapper extends Mapper<Gametrade> {
    int countByExample(GametradeExample example);

    int deleteByExample(GametradeExample example);

    List<Gametrade> selectByExample(GametradeExample example);

    int updateByExampleSelective(@Param("record") Gametrade record, @Param("example") GametradeExample example);

    int updateByExample(@Param("record") Gametrade record, @Param("example") GametradeExample example);
}