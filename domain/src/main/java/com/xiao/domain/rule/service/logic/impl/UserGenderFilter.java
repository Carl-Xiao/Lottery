package com.xiao.domain.rule.service.logic.impl;

import com.xiao.domain.rule.model.req.DecisionMatterReq;
import com.xiao.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @description: 性别规则
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
@Component
public class UserGenderFilter extends BaseLogic {
    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
}
