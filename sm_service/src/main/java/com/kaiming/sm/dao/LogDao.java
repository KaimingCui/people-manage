package com.kaiming.sm.dao;

import com.kaiming.sm.entity.Log;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
@Primary
public interface LogDao {
    public void insert(Log log);

    public List<Log> selectByType(String type);
}
