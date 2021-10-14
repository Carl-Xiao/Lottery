package com.xiao.infrastructure.repository;

import com.xiao.common.Constants;
import com.xiao.domain.activity.model.vo.*;
import com.xiao.domain.activity.repository.IActivityRepository;
import com.xiao.infrastructure.dao.IActivityDao;
import com.xiao.infrastructure.dao.IAwardDao;
import com.xiao.infrastructure.dao.IStrategyDao;
import com.xiao.infrastructure.dao.IStrategyDetailDao;
import com.xiao.infrastructure.po.Activity;
import com.xiao.infrastructure.po.Award;
import com.xiao.infrastructure.po.Strategy;
import com.xiao.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 抽奖系统
 * @author：Carl-Xiao
 * @date: 2021/10/14
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao iActivityDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    IStrategyDao iStrategyDao;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Constants.ActivityState afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = iActivityDao.alterState(alterStateVO);
        return count==1;
    }

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        iActivityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);

    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        iStrategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }


}
