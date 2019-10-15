package com.fuyong.imwebtest.service;


import com.fuyong.imwebtest.dao.PersonMapper;
import com.fuyong.imwebtest.dao.UserRepository;
import com.fuyong.imwebtest.pojo.Person;
import com.fuyong.imwebtest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> query(){
        return userRepository.findAll();
    }


}
