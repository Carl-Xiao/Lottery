package cn.xiao.test.dao;

import com.xiao.App;
import com.xiao.infrastructure.dao.IUserTakeActivityDao;
import com.xiao.infrastructure.po.UserTakeActivity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description:  测试用户领取活动表
 * @author：carl
 * @date: 2021/10/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
@Slf4j
public class UserTakeActivityDaoTest {
    private Logger logger = LoggerFactory.getLogger(UserTakeActivityDaoTest.class);

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Test
    public void test_insert() {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setuId("Uhdgkw766120d"); // 1库：Ukdli109op89oi 2库：Ukdli109op811d
        userTakeActivity.setTakeId(121019889410L);
        userTakeActivity.setActivityId(100001L);
        userTakeActivity.setActivityName("测试活动");
        userTakeActivity.setTakeDate(new Date());
        userTakeActivity.setTakeCount(10);
        userTakeActivity.setUuid("Uhdgkw766120d");
        userTakeActivityDao.insert(userTakeActivity);
    }
}
