package com.kaiming.sm.service;

import com.kaiming.sm.entity.Staff;

public interface SelfService {
    public Staff login(String account, String password);

    public void changePassword(Integer id, String password);
}
