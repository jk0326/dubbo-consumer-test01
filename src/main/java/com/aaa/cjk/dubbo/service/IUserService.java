package com.aaa.cjk.dubbo.service;

import com.aaa.cjk.dubbo.model.User;

import java.util.Map;

public interface IUserService {

    Map<String,Object> getOneUser(User user);
}
