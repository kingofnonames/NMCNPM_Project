package com.cnpm.household_management.controller;

import com.cnpm.household_management.dto.StatisticResponse;
import com.cnpm.household_management.dto.StatisticRequest;
import com.cnpm.household_management.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/statistics")
    public ResponseEntity<StatisticResponse> filterResidents(@ModelAttribute StatisticRequest request) {
        StatisticResponse response = statisticService.filterResidents(request);
        return ResponseEntity.ok(response);
    }
}