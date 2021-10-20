package com.xiao.domain.support.impl;

import com.xiao.domain.support.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @description: 随机生成策略ID
 * @author：Carl-Xiao
 * @date: 2021/10/20
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        String randomUuid = RandomStringUtils.randomNumeric(11);
        return Long.parseLong(randomUuid);
    }
}
