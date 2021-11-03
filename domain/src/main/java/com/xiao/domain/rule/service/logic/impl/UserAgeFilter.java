package com.xiao.domain.rule.service.logic.impl;

import com.xiao.domain.rule.model.req.DecisionMatterReq;
import com.xiao.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
@Component
public class UserAgeFilter extends BaseLogic {
    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }
}
