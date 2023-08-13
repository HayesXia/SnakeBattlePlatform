package com.projectpractice.backend.service.impl.user.bot;

import com.projectpractice.backend.controller.user.bot.AddService;
import com.projectpractice.backend.mapper.BotMapper;
import com.projectpractice.backend.pojo.Bot;
import com.projectpractice.backend.pojo.User;
import com.projectpractice.backend.service.impl.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private BotMapper botMapper;



    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if (title == null || title.length() == 0) {
            map.put("error_message", "Title shouldn't be empty!");
            return map;
        }

        if (title.length() > 100) {
            map.put("error_message", "The length of tile shouldn't over 100!");
            return map;
        }

        if (description == null || description.length() == 0) {
            description = "Lazy guy left nothing here~";
        }

        if (description.length() > 500) {
            map.put("error_message", "The length of description shouldn't over 500");
            return map;
        }

        if (content == null || content.length() == 0) {
            map.put("error_message", "The code shouldn't be empty!");
            return map;
        }

        if (content.length() > 10000) {
            map.put("error_message", "The length of code shouldn't over 10000!");
            return map;
        }

        Date now = new Date();
        Bot bot = new Bot(null, user.getId(), title, description, content, 1500, now, now);

        botMapper.insert(bot);
        map.put("error_message", "Success!");



        return map;
    }
}
