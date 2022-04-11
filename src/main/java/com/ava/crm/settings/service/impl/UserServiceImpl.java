package com.ava.crm.settings.service.impl;

import com.ava.crm.settings.dao.UserDao;
import com.ava.crm.settings.service.UserService;
import com.ava.crm.utils.SqlSessionUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

}
