package com.xiao.domain.rule.model.req;

import lombok.Data;

import java.util.Map;

/**
 * @description:
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
@Data
public class DecisionMatterReq {
    /** 规则树ID */
    private Long treeId;
    /** 用户ID */
    private String userId;
    /** 决策值 */
    private Map<String, Object> valMap;
}
