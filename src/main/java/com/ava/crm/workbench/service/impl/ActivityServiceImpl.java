package com.ava.crm.workbench.service.impl;

import com.ava.crm.utils.SqlSessionUtil;
import com.ava.crm.workbench.dao.ActivityDao;
import com.ava.crm.workbench.domain.Activity;
import com.ava.crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao = SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    @Override
    public boolean save(Activity activity) {

        boolean flag = true;

        int count = activityDao.save(activity);
        if (count != 1) {
            flag = false;
        }

        return flag;
    }
}
