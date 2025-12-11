package com.cnpm.household_management.dto;

import com.cnpm.household_management.model.Resident;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticResponse {
    // Tổng số lượng tìm thấy
    private long totalCount;
    
    // Danh sách chi tiết
    private List<Resident> data;
}