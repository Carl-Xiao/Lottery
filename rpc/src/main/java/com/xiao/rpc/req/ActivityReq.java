package com.xiao.rpc.req;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityReq implements Serializable {
    private Long activityId;
}
