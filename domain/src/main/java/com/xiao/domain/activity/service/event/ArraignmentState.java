package com.xiao.domain.activity.service.event;

import com.xiao.common.Constants;
import com.xiao.common.Result;
import com.xiao.domain.activity.service.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @description: 提审状态
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
@Component
public class ArraignmentState extends AbstractState {

    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "待审核状态不可重复提审");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return null;
    }
}
