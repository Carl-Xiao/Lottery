package com.xiao.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawReq {
    //用户ID
    private String uId;
    // 策略ID
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;
}
