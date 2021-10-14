package com.xiao.domain.strategy.model.aggregates;


import com.xiao.domain.strategy.model.vo.StrategyBriefVO;
import com.xiao.domain.strategy.model.vo.StrategyDetailBriefVO;
import lombok.Data;

import java.util.List;

@Data
public class StrategyRich {
    // 策略ID
    private Long strategyId;

    //策略配置
    private StrategyBriefVO strategy;
    /**
     * 策略明细
     */
    private List<StrategyDetailBriefVO> strategyDetailList;
    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

}
