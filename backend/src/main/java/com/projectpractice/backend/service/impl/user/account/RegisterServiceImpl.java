package com.projectpractice.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.projectpractice.backend.mapper.UserMapper;
import com.projectpractice.backend.pojo.User;
import com.projectpractice.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "username cannot be empty");
            return map;
        }
        if (password == null || confirmedPassword == null) {
            map.put("error_message", "password cannot be empty");
        }

        username = username.trim();        //trim函数能去掉字符串首尾的空格、回车等字符
        if (username.length() == 0) {
            map.put("error_message", "username cannot be empty");
            return map;
        }

        assert password != null;
        if (password.length() == 0 || Objects.requireNonNull(confirmedPassword).length() == 0) {
            map.put("error_message", "password canot be empty");
        }

        if (username.length() > 100) {
            map.put("error_message", "the length of username cannot over 100");
            return map;
        }

        if (password.length() > 100 || Objects.requireNonNull(confirmedPassword).length() > 100) {
            map.put("error_message", "the length of password cannot over 100");
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "the two password inputs are inconsistent");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "this username has already existed");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String head_sculpture = "https://img2.doubanio.com/view/subject/m/public/s28990953.jpg";
        User user = new User(null, username, encodedPassword, head_sculpture);
        userMapper.insert(user);

        map.put("error_messsage", "success");
        return map;
    }
}
