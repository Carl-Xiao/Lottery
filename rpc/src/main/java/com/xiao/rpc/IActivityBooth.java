package com.xiao.rpc;

import com.xiao.rpc.req.ActivityReq;
import com.xiao.rpc.res.ActivityRes;

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
