package com.xiao.domain.activity.service.deploy;

import com.xiao.domain.activity.model.req.ActivityConfigReq;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);
}
