package com.xiao.application.process.res;

import com.xiao.common.Result;
import com.xiao.domain.strategy.model.vo.DrawAwardInfo;
import lombok.Data;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/26
 */
@Data
public class DrawProcessResult extends Result {
    private DrawAwardInfo drawAwardInfo;

    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardInfo drawAwardInfo) {
        super(code, info);
        this.drawAwardInfo = drawAwardInfo;
    }
}
