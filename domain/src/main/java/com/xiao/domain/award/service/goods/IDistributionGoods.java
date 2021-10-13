package com.xiao.domain.award.service.goods;

import com.xiao.domain.award.model.req.GoodsReq;
import com.xiao.domain.award.model.res.DistributionRes;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/13
 */
public interface IDistributionGoods {

    /**
     * 奖品配送接口 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     * @param req 物品信息
     * @return 配送结果
     */
    DistributionRes doDistribution(GoodsReq req);

}
