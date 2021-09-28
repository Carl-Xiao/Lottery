package com.xiao.rpc.res;

import com.xiao.common.Result;
import com.xiao.rpc.dto.ActivityDto;
import lombok.Data;

@Data
public class ActivityRes {
    private Result result;
    private ActivityDto activity;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activity) {
        this.result = result;
        this.activity = activity;
    }
}
