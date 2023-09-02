package com.projectpractice.backend.service.user.account.HayeWin;

import com.alibaba.fastjson.JSONObject;

public interface AcAppService {
    JSONObject applyCode();
    JSONObject receiveCode(String code, String state);
}
