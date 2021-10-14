package com.xiao.domain.activity.model.aggregates;

import com.xiao.domain.activity.model.vo.ActivityVO;
import com.xiao.domain.activity.model.vo.AwardVO;
import com.xiao.domain.activity.model.vo.StrategyVO;
import lombok.Data;

import java.util.List;

/**
 * @description: 活动配置聚合信息
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
@Data
public class ActivityConfigRich {
    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }


}
