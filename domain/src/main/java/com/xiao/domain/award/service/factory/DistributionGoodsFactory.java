package com.xiao.domain.award.service.factory;

import com.xiao.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/13
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }

}
