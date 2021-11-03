package com.xiao.domain.rule.model.aggregates;

import com.xiao.domain.rule.model.vo.TreeNodeVO;
import com.xiao.domain.rule.model.vo.TreeRootVO;
import lombok.Data;

import java.util.Map;

/**
 * @description: 规则树聚合
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
@Data
public class TreeRuleRich {
    /** 树根信息 */
    private TreeRootVO treeRoot;
    /** 树节点ID -> 子节点 */
    private Map<Long, TreeNodeVO> treeNodeMap;
}
