package com.xiao.domain.strategy.service.draw;

import com.xiao.domain.strategy.model.vo.AwardRateInfo;
import com.xiao.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.xiao.infrastructure.po.StrategyDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/10
 */
public class DrawBase extends DrawConfig{

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        //初始化策略
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }

}
