package com.xiao.service;

import com.xiao.common.Result;
import com.xiao.infrastructure.dao.IActivityDao;
import com.xiao.infrastructure.po.Activity;
import com.xiao.rpc.IActivityBooth;
import com.xiao.rpc.dto.ActivityDto;
import com.xiao.rpc.req.ActivityReq;
import com.xiao.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;


    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(Result.buildSuccessResult(), activityDto);
    }
}
