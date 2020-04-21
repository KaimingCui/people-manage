package com.kaiming.sm.service;

import com.kaiming.sm.entity.Log;

import java.util.List;

public interface LogService {
    public void addSystemLog(Log log);

    public void addLoginLog(Log log);

    public void addOperationLog(Log log);

    List<Log> getSystemLog();

    List<Log> getLoginLog();

    List<Log> getOperationLog();
}
