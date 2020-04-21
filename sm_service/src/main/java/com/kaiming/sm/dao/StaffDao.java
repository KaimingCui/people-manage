package com.kaiming.sm.dao;


import com.kaiming.sm.entity.Staff;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
@Primary
public interface StaffDao {
    void insert(Staff staff);

    void delete(Integer id);

    void update(Staff staff);

    Staff selectById(Integer id);

    List<Staff> selectAll();
}
