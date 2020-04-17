package com.wu.kong.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.wu.kong.dao.EmployeeMapper;
import com.wu.kong.dao.NameMapper;
import com.wu.kong.model.Employee;
import com.wu.kong.model.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Employee")
@RestController
public class UserController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private NameMapper nameMapper;

    @RequestMapping("/Employee")
    public String getUser(Employee employee) {

        System.out.println(employee);
        return employee.getLastName();
    }

    @RequestMapping(
            value = {"/get/{id}"},
            method = {RequestMethod.GET}
    )
    public Employee getById(@PathVariable Integer id) {
        Employee employee = new Employee();
        employee = employeeMapper.selectById(id);
        return employee;
    }

    @RequestMapping(
            value = {"/add"},
            method = {RequestMethod.POST}
    )
    public void add(Employee employee) {
        //Employee employee = new Employee();
//        employee.setAge(25);
//        employee.setEmail("sunmengyuan@sun.com");
//        employee.setGender(1);
        Integer result = this.employeeMapper.insert(employee);
        System.out.println(result);
    }

    @RequestMapping(
            value = {"/up"},
            method = {RequestMethod.PUT}
    )
    public void up() {
        Employee employee = new Employee();

        employee.setLastName("sun");
        Integer result = this.employeeMapper.updateById(employee);
        System.out.println(result);
    }

    @RequestMapping(
            value = {"/all"},
            method = {RequestMethod.GET}
    )
    public Page<Employee> getAll() {
        Page<Employee> page = new Page<>(1, 5);
        List<Employee> emps = this.employeeMapper.selectPage(page, null);

        System.out.println("=====获取分页相关信息： " + emps);
        page.setRecords(emps);

        return page;
    }

    @RequestMapping(
            value = {"/locker"},
            method = {RequestMethod.GET}
    )
    public void testOptimisticLocker() {
        // 乐观锁demo 模拟一个更新操作
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("远哥哥");
        employee.setEmail("yuangege@sun.com");
        employee.setGender(1);
        employee.setAge(100);
        employee.setVersion(1);
        this.employeeMapper.updateById(employee);
    }

    @RequestMapping(//逻辑删除
            value = {"/del"},
            method = {RequestMethod.DELETE}
    )
    public void test_del() {
        Integer result = nameMapper.deleteById(1);

        System.out.println(result);

    }

    @RequestMapping(
            value = {"/getName/{id}"},
            method = {RequestMethod.GET}
    )
    public Name getById_2(@PathVariable Integer id) {
        Name name = new Name();
        name = nameMapper.selectById(id);

        System.out.println(name);
        return name;

    }

    /*
     * 测试公共字段自动填充
     * */
    @RequestMapping(
            value = {"/Name/insert"},
            method = {RequestMethod.POST}
    )
    public void NameInsert() {
        Name name = new Name();
        name.setIs_del(1);
        this.nameMapper.insert(name);


    }
}
