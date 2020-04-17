package com.ribbonprovider.provider.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//服务端id,我们的服务端，也就是provider项目的项目id 就是 RINNON-SERVICE
public interface StudentService {
    /*
     * 获取所有学生列表
     * @return
     * */
    @GetMapping(value = "/myfeign/student")
    String getAllStudent();

    /*
     * 添加学生
     * @param student
     * @return
     *
     * */
    @PostMapping(value = "/myfeign/student")
    String saveStudent(@RequestBody Student student);
}
