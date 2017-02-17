package cn.mazekkkk.product.service;

import cn.mazekkkk.product.dao.common.Gametrade;

import java.util.List;

/**
 * Created by maze on 17/1/25.
 */
public interface GameTradeService {
    /**
     * 保存游戏交易
     * @param gametrade 游戏交易对象
     */
    void saveGameTrade(Gametrade gametrade);

    /**
     * 获取游戏交易分页信息
     * @return
     */
    List<Gametrade> getGameTrdePage(Integer page);
}
