package com.xiao.domain.support;

/**
 * @description: ID生成策略
 * @author：Carl-Xiao
 * @date: 2021/10/20
 */
public interface IIdGenerator {

    /**
     * 1 雪花算法的分布式ID(没有解决时钟回拨的问题)
     * 2 随机算法,生成策略ID
     * @return ID
     */
    long nextId();
}
