package com.ava.crm.settings.dao;

import com.ava.crm.settings.domain.User;

import java.util.Map;

public interface UserDao {

    User login(Map<String, String> map);
}
