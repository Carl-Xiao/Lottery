package com.xiao.domain.rule.model.vo;

import lombok.Data;

/**
 * @description: 规则树线信息
 * @author：Carl-Xiao
 * @date: 2021/11/3
 */
@Data
public class TreeNodeLineVO {
    /** 节点From */
    private Long nodeIdFrom;
    /** 节点To */
    private Long nodeIdTo;
    /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;
}
