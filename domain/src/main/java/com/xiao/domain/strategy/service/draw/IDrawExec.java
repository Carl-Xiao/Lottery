package com.xiao.domain.strategy.service.draw;

import com.xiao.domain.strategy.model.req.DrawReq;
import com.xiao.domain.strategy.model.res.DrawResult;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/10
 */
public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
