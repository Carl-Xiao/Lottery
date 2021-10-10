package com.xiao.domain.strategy.service.draw.impl;

import com.xiao.domain.strategy.model.aggregates.StrategyRich;
import com.xiao.domain.strategy.model.req.DrawReq;
import com.xiao.domain.strategy.model.res.DrawResult;
import com.xiao.domain.strategy.repository.IStrategyRepository;
import com.xiao.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.xiao.domain.strategy.service.draw.DrawBase;
import com.xiao.domain.strategy.service.draw.IDrawExec;
import com.xiao.infrastructure.po.Award;
import com.xiao.infrastructure.po.Strategy;
import com.xiao.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/10
 */
@Service("drawExec")
@Slf4j
public class DrawExecImpl extends DrawBase implements IDrawExec {
    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    public DrawResult doDrawExec(DrawReq req) {
        log.info("执行策略抽奖开始，strategyId：{}", req.getStrategyId());
        //策略信息
        StrategyRich strategyRich = strategyRepository.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();
        //检查初始化
        checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyDetailList);
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());
        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());
        // 获取奖品信息
        Award award = strategyRepository.queryAwardInfo(awardId);
        log.info("执行策略抽奖完成，中奖用户：{} 奖品ID：{} 奖品名称：{}", req.getUId(), awardId, award.getAwardName());
        return new DrawResult(req.getUId(), req.getStrategyId(), awardId, award.getAwardName());
    }
}
