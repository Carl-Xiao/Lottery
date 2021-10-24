package com.xiao.infrastructure.dao;

import com.xiao.domain.activity.model.vo.AlterStateVO;
import com.xiao.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IActivityDao {

    /**
     * 插入activity数据
     * @param req
     */
    void insert(Activity req);

    /**
     * 通过ID获取活动信息
     * @param activityId 活动ID
     * @return
     */
    Activity queryActivityById(Long activityId);

    /**
     * 变更活动状态
     *
     * @param alterStateVO  [activityId、beforeState、afterState]
     * @return 更新数量
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * 扣减活动库存
     * @param activityId 活动ID
     * @return 更新数量
     */
    int subtractionActivityStock(Long activityId);
}
