package com.kaiming.sm.dao;

import com.kaiming.sm.entity.Department;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("departmentDao")
@Primary
public interface DepartmentDao {

    public void insert(Department department);

    public void delete(Integer id);

    public void update(Department department);

    public Department selectById(Integer id);

    public List<Department> selectAll();

}
