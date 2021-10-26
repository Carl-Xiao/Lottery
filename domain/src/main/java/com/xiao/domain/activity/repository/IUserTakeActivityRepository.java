package com.xiao.domain.activity.repository;

import com.xiao.domain.activity.model.vo.DrawOrderVO;
import com.xiao.domain.activity.model.vo.UserTakeActivityVO;

import java.util.Date;

/**
 * @description: 用户参与活动仓储接口
 * @author：carl
 * @date: 2021/10/24
 */
public interface IUserTakeActivityRepository {
    /**
     * 扣减个人活动参与次数
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param partakeDate       领取时间
     * @return                  更新结果
     */
    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    /**
     * 领取活动
     *
     * @param activityId        活动ID
     * @param activityName      活动名称
     * @param takeCount         活动个人可领取次数
     * @param userTakeLeftCount 活动个人剩余领取次数
     * @param uId               用户ID
     * @param takeDate          领取时间
     * @param takeId            领取ID
     */
    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);

    /**
     * 锁定活动领取记录
     *
     * @param uId        用户ID
     * @param activityId 活动ID
     * @param takeId     领取ID
     * @return 更新结果
     */
    int lockTackActivity(String uId, Long activityId, Long takeId);

    void saveUserStrategyExport(DrawOrderVO drawOrder);
}
