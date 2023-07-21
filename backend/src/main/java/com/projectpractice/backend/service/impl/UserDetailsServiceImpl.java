package com.projectpractice.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.projectpractice.backend.mapper.UserMapper;
import com.projectpractice.backend.pojo.User;
import com.projectpractice.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new RuntimeException("User Do Not Exist!");
        }

        return new UserDetailsImpl(user);
    }
}
