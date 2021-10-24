package com.xiao.domain.activity.service.partake;

import com.xiao.domain.activity.model.req.PartakeReq;
import com.xiao.domain.activity.model.res.PartakeResult;

/**
 * @description: 抽奖活动参与接口
 * @author：carl
 * @date: 2021/10/24
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 入参
     * @return    领取结果
     */
    PartakeResult doPartake(PartakeReq req);

}
