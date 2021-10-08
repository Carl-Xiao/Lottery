package com.xiao.rpc.test;


import com.alibaba.fastjson.JSON;
import com.xiao.AppTest;
import com.xiao.rpc.IActivityBooth;
import com.xiao.rpc.req.ActivityReq;
import com.xiao.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppTest.class)
public class ApiTest {

    @DubboReference
    private IActivityBooth activityBooth;

    @Test
    public void test_rpc() {
        ActivityReq req = new ActivityReq();
        req.setActivityId(100001L);
        ActivityRes result = activityBooth.queryActivityById(req);
        System.out.println("测试结果：{}" + JSON.toJSONString(result));
    }

}
