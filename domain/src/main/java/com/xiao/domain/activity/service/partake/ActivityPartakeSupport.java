package com.xiao.domain.activity.service.partake;

import com.xiao.domain.activity.model.req.PartakeReq;
import com.xiao.domain.activity.model.vo.ActivityBillVO;
import com.xiao.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description: 活动领取模操作，一些通用的数据服务
 * @author：carl
 * @date: 2021/10/24
 */
public class ActivityPartakeSupport {
    @Resource
    protected IActivityRepository activityRepository;


    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}
