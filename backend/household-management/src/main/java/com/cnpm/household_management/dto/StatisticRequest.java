package com.cnpm.household_management.dto;

import lombok.Data;

@Data
public class StatisticRequest {
    // Tìm theo mã hộ khẩu (tìm gần đúng)
    private String householdBookID;
    
    // Tìm theo tên (tìm gần đúng)
    private String fullName;

    // Tìm theo khoảng độ tuổi
    private Integer minAge;
    private Integer maxAge;

    // Tìm theo quê quán
    private String hometown;

    // Tìm theo dân tộc
    private String ethnicity;

    // Tìm theo nghề nghiệp
    private String occupation;

    // Trạng thái: null = tất cả, false = còn sống, true = đã mất
    private Boolean isDead;
}