package com.xiao.domain.award.service.factory;

import com.xiao.common.Constants;
import com.xiao.domain.award.service.goods.IDistributionGoods;
import com.xiao.domain.award.service.goods.imp.CouponGoods;
import com.xiao.domain.award.service.goods.imp.DescGoods;
import com.xiao.domain.award.service.goods.imp.PhysicalGoods;
import com.xiao.domain.award.service.goods.imp.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 抽奖系统 各类发奖奖品配置类
 * @author：Carl-Xiao
 * @date: 2021/10/13
 */
public class GoodsConfig {
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    CouponGoods couponGoods;
    @Resource
    DescGoods descGoods;

    @Resource
    RedeemCodeGoods redeemCodeGoods;

    @Resource
    PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }



}
