package com.wu.kong.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wu.kong.model.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

}

