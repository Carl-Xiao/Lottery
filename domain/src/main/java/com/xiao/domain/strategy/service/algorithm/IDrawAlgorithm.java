package com.xiao.domain.strategy.service.algorithm;

import com.xiao.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {

    /**
     *
     * @param strategyId  策略ID
     * @param awardRateInfoList 奖品概率配置集合 「值示例：AwardRateInfo.awardRate = 0.04」
     */
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    /**
     * 判断是否已经，做了数据初始化
     * @param strategyId
     * @return
     */
    boolean isExistRateTuple(Long strategyId);
    /**
     * SecureRandom 生成随机数，索引到对应的奖品信息返回结果
     *
     * @param strategyId 策略ID
     * @param excludeAwardIds 排除掉已经不能作为抽奖的奖品ID，留给风控和空库存使用
     * @return 中奖结果
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}
