package com.kaiming.sm.service.impl;

import com.kaiming.sm.dao.SelfDao;
import com.kaiming.sm.dao.StaffDao;
import com.kaiming.sm.entity.Staff;
import com.kaiming.sm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if (staff == null) {
            return null;
        }

        if (staff.getPassword().equals(password)) {
            return staff;
        }

        return null;
    }

    @Override
    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
