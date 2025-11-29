package com.cnpm.household_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class TestController {
    @Autowired
    private JdbcTemplate jdpcTemplate;

    @GetMapping("test")
    public String test(){
        String sql = "CREATE TABLE IF NOT EXISTS test_table_ver2011 (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR(255) NOT NULL" +
        ")";
        jdpcTemplate.execute(sql);
        return "Đã tạo bảng thành công";
    }
}
