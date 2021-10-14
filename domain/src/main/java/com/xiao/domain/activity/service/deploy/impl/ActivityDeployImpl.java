package com.xiao.domain.activity.service.deploy.impl;

import com.xiao.domain.activity.model.aggregates.ActivityConfigRich;
import com.xiao.domain.activity.model.req.ActivityConfigReq;
import com.xiao.domain.activity.model.vo.ActivityVO;
import com.xiao.domain.activity.model.vo.AwardVO;
import com.xiao.domain.activity.model.vo.StrategyDetailVO;
import com.xiao.domain.activity.model.vo.StrategyVO;
import com.xiao.domain.activity.repository.IActivityRepository;
import com.xiao.domain.activity.service.deploy.IActivityDeploy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
@Service
@Slf4j
public class ActivityDeployImpl implements IActivityDeploy {
    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        log.info("创建活动配置开始，activityId：{}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        // 添加活动配置
        ActivityVO activity = activityConfigRich.getActivity();
        activityRepository.addActivity(activity);

        // 添加奖品信息
        List<AwardVO> awardList = activityConfigRich.getAwardList();
        activityRepository.addAward(awardList);

        // 添加策略配置
        StrategyVO strategy = activityConfigRich.getStrategy();
        activityRepository.addStrategy(strategy);

        // 添加策略明细配置
        List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();
        activityRepository.addStrategyDetailList(strategyDetailList);
        log.info("创建活动配置完成，activityId：{}", req.getActivityId());
    }
}
