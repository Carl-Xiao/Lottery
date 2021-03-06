package com.xiao.domain.strategy.service.algorithm.impl;

import com.xiao.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        if (rateTuple == null) {
            return  null;
        }
        //索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);
        //获取奖品
        String awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) return "未中奖";
        return awardId;
    }
}
