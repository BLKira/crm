package com.ava.crm.workbench.service.impl;

import com.ava.crm.utils.SqlSessionUtil;
import com.ava.crm.vo.PaginationVO;
import com.ava.crm.workbench.dao.ActivityDao;
import com.ava.crm.workbench.domain.Activity;
import com.ava.crm.workbench.service.ActivityService;

import java.util.List;
import java.util.Map;

public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    public boolean save(Activity activity) {

        boolean flag = true;

        int count = activityDao.save(activity);
        if (count != 1) {
            flag = false;
        }

        return flag;
    }

    public PaginationVO<Activity> pageList(Map<String, Object> map) {

//        取得total
        int total = activityDao.getTotalByCondition(map);
//        取得dataList
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
//        将total及pageList封装到vo中
        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setTotal(total);
        vo.setDataList(dataList);

//        将vo返回
        return vo;
    }
}
