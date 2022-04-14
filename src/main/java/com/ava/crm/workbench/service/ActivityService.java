package com.ava.crm.workbench.service;

import com.ava.crm.vo.PaginationVO;
import com.ava.crm.workbench.domain.Activity;

import java.util.Map;

public interface ActivityService {
    boolean save(Activity activity);

    PaginationVO<Activity> pageList(Map<String, Object> map);
}
