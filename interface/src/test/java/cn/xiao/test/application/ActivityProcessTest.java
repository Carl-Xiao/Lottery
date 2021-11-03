package cn.xiao.test.application;

import com.alibaba.fastjson.JSON;
import com.xiao.App;
import com.xiao.application.process.IActivityProcess;
import com.xiao.application.process.req.DrawProcessReq;
import com.xiao.application.process.res.DrawProcessResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @description: 抽奖系统
 * @author：carl
 * @date: 2021/10/26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
@Slf4j
public class ActivityProcessTest {
    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setUId("fustack");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        log.info("请求入参：{}", JSON.toJSONString(req));
        log.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }

}
