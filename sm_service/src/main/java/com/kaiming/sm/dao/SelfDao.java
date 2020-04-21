package com.kaiming.sm.dao;

import com.kaiming.sm.entity.Staff;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
@Primary
public interface SelfDao {
    public Staff selectByAccount(String account);
}
