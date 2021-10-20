package com.xiao.domain.support.impl;

import com.xiao.domain.support.IIdGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @description:
 * @author：Carl-Xiao
 * @date: 2021/10/20
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public long nextId() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int week = now.getMonth().getValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        StringBuilder idStr = new StringBuilder();
        idStr.append(year - 2020);
        idStr.append(hour);
        idStr.append(String.format("%02d", week));
        idStr.append(day);
        idStr.append(String.format("%03d", new Random().nextInt(1000)));
        return Long.parseLong(idStr.toString());
    }
}
