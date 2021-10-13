package com.xiao.domain.strategy.service.draw;

import com.xiao.common.Constants;
import com.xiao.domain.strategy.model.aggregates.StrategyRich;
import com.xiao.domain.strategy.model.req.DrawReq;
import com.xiao.domain.strategy.model.res.DrawResult;
import com.xiao.domain.strategy.model.vo.AwardRateInfo;
import com.xiao.domain.strategy.model.vo.DrawAwardInfo;
import com.xiao.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.xiao.infrastructure.po.Award;
import com.xiao.infrastructure.po.Strategy;
import com.xiao.infrastructure.po.StrategyDetail;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 抽奖系统 定义抽象抽奖过程，模板模式
 * @author：Carl-Xiao
 * @date: 2021/10/12
 */
@Slf4j
public abstract class AbstractDrawBase extends DrawStrategySupport implements IDrawExec {

    @Override
    public DrawResult doDrawExec(DrawReq req) {

        //根据入参策略ID获取抽奖策略配置
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        Strategy strategy = strategyRich.getStrategy();
        //校验和处理抽奖策略的数据初始化到内存
        checkAndInitRateData(strategy.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());
        // 获取那些被排除掉的抽奖列表，这些奖品可能是已经奖品库存为空，或者因为风控策略不能给这个用户薅羊毛的奖品
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());
        // 执行抽奖算法
        String awardId = drawAlgorithm(strategy.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIds);
        // 包装中奖结果
        return buildDrawResult(req.getUId(), req.getStrategyId(), awardId);
    }

    /**
     * 获取不在抽奖范围内的列表，包括：奖品库存为空、风控策略、临时调整等，这类数据是含有业务逻辑的，所以需要由具体的实现方决定
     *
     * @param strategyId 策略ID
     * @return 排除的奖品ID集合
     */
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @param strategyId      策略ID
     * @param drawAlgorithm   抽奖算法模型
     * @param excludeAwardIds 排除的抽奖ID集合
     * @return 中奖奖品ID
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);


    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetail> strategyDetailList) {
        if (1 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);
        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) {return;}
        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetail strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }
        //初始化策略
        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }


    private DrawResult buildDrawResult(String uId, Long strategyId, String awardId) {
        if (null == awardId) {
            log.info("执行策略抽奖完成【未中奖】，用户：{} 策略ID：{}", uId, strategyId);
            return new DrawResult(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }
        Award award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardInfo drawAwardInfo = new DrawAwardInfo(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        log.info("执行策略抽奖完成【已中奖】，用户：{} 策略ID：{} 奖品ID：{} 奖品名称：{}", uId, strategyId, awardId, award.getAwardName());

        return new DrawResult(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardInfo);
    }

}
