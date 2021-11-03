package com.xiao.domain.rule.service.engine;

import com.xiao.domain.rule.model.req.DecisionMatterReq;
import com.xiao.domain.rule.model.res.EngineResult;

/**
 * @description:
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
public interface EngineFilter {

    EngineResult process(final DecisionMatterReq matter);
}
