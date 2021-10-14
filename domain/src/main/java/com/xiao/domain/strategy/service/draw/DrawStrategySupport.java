package com.xiao.domain.strategy.service.draw;

import com.xiao.domain.strategy.model.aggregates.StrategyRich;
import com.xiao.domain.strategy.model.vo.AwardBriefVO;
import com.xiao.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/12
 */
public class DrawStrategySupport extends DrawConfig{
    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略的配置信息
     * @param strategyId
     * @return
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品的详细信息
     * @param awardId
     * @return
     */
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }



}
