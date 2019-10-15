package com.fuyong.imwebtest.service;


import com.fuyong.imwebtest.dao.PersonMapper;
import com.fuyong.imwebtest.dao.UserRepository;
import com.fuyong.imwebtest.pojo.Person;
import com.fuyong.imwebtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    private UserRepository userRepository;


    public Person queryLimtOne(){
       return personMapper.queryLimtOne();
    }



    public List<User> query(){
        return userRepository.findAll();
    }


}
