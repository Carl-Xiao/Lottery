package com.xiao.domain.activity.model.res;

import com.xiao.common.Result;
import lombok.Data;

/**
 * @description: 活动参与结果
 * @author：carl
 * @date: 2021/10/24
 */
@Data
public class PartakeResult extends Result {
    /**
     * 策略ID
     */
    private Long strategyId;
    /**
     * 活动领取ID
     */
    private Long takeId;

    public PartakeResult(String code, String info) {
        super(code, info);
    }

}
