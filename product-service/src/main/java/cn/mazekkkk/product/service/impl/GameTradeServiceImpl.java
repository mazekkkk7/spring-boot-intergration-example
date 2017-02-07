package cn.mazekkkk.product.service.impl;

import cn.mazekkkk.product.dao.common.Gametrade;
import cn.mazekkkk.product.dao.mapper.GametradeMapper;
import cn.mazekkkk.product.service.GameTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maze on 17/1/25.
 */
@Service
public class GameTradeServiceImpl implements GameTradeService {

    @Autowired
    private GametradeMapper gametradeMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 保存游戏交易
     * @param gametrade 游戏交易对象
     */
    @Override
    public void saveGameTrade(Gametrade gametrade) {
        gametradeMapper.insert(gametrade);
        logger.info("gameTrade主键回显为:"+gametrade.getId());
    }
}
