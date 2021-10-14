package com.xiao.domain.activity.service;

import com.xiao.common.Constants;
import com.xiao.common.Result;

/**
 * @description: 活动状态抽象类
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
public abstract class AbstractState {

    /**
     * 活动提审
     * @param activityId 活动ID
     * @param currentState 运行状态
     * @return
     */
    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核通过
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核拒绝
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 审核撤销
     * @param activityId 活动ID
     * @param currentState
     * @return
     */
    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动关闭
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result close(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动开启
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result open(Long activityId, Enum<Constants.ActivityState> currentState);

    /**
     * 活动正在执行中
     * @param activityId
     * @param currentState
     * @return
     */
    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> currentState);



}
