package com.xiao.domain.activity.repository;

import com.xiao.common.Constants;
import com.xiao.domain.activity.model.req.PartakeReq;
import com.xiao.domain.activity.model.vo.*;

import java.util.List;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
public interface IActivityRepository {

    /**
     * 变更活动状态
     * @param activityId
     * @param currentState
     * @param pass
     * @return
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> currentState, Constants.ActivityState pass);

    /**
     * 添加活动配置
     * @param activity 活动配置
     */
    void addActivity(ActivityVO activity);

    void addAward(List<AwardVO> awardList);

    void addStrategy(StrategyVO strategy);

    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    ActivityBillVO queryActivityBill(PartakeReq req);

    int subtractionActivityStock(Long activityId);
}
