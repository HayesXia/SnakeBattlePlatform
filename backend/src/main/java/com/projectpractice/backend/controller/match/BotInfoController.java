package com.projectpractice.backend.controller.match;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/match/")

public class BotInfoController {

    @RequestMapping("getbotinfo/")
    public Map<String, String> getBotInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Haye");
        map.put("rating", "2000");
        return map;
    }
}
