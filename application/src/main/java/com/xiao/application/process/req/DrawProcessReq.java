package com.xiao.application.process.req;

import lombok.Data;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/26
 */
@Data
public class DrawProcessReq {
    /** 用户ID */
    private String uId;
    /** 活动ID */
    private Long activityId;

    public DrawProcessReq() {
    }

    public DrawProcessReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
    }

}
