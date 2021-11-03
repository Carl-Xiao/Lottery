package com.xiao.domain.rule.repository;

import com.xiao.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @description: 规则信息仓储服务接口
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
public interface IRuleRepository {
    /**
     * 查询规则决策树配置
     * @param treeId    决策树ID
     * @return          决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}
