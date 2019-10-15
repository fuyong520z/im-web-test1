package com.fuyong.imwebtest.dao;


import com.fuyong.imwebtest.pojo.Person;

public interface PersonMapper {
    int insert(Person record);

    int insertSelective(Person record);


    Person queryLimtOne();
}