package com.kaiming.sm.service.impl;


import com.kaiming.sm.dao.StaffDao;
import com.kaiming.sm.entity.Staff;
import com.kaiming.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("normal");
        staffDao.insert(staff);
    }

    public void remove(Integer id) {
        staffDao.delete(id);
    }

    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    public Staff get(Integer id) {
        return staffDao.selectById(id);
    }

    public List<Staff> getAll() {
        return staffDao.selectAll();
    }
}
