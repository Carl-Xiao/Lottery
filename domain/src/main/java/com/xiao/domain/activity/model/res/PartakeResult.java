package com.xiao.domain.activity.model.res;

import com.xiao.common.Result;

/**
 * @description: 活动参与结果
 * @author：carl
 * @date: 2021/10/24
 */
public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
}
