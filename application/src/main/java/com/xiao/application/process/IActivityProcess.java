package com.xiao.application.process;

import com.xiao.application.process.req.DrawProcessReq;
import com.xiao.application.process.res.DrawProcessResult;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/26
 */
public interface IActivityProcess {
    /**
     * 执行抽奖请求
     * @param req
     * @return
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
