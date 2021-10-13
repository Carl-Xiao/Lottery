package com.xiao.domain.award.service.goods.imp;

import com.xiao.common.Constants;
import com.xiao.domain.award.model.req.GoodsReq;
import com.xiao.domain.award.model.res.DistributionRes;
import com.xiao.domain.award.service.goods.DistributionBase;
import com.xiao.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/13
 */
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        // 模拟调用实物发奖
        logger.info("模拟调用实物发奖 uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }
}
