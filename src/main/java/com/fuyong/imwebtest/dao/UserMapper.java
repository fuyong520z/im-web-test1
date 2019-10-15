package com.fuyong.imwebtest.dao;


import com.fuyong.imwebtest.pojo.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}