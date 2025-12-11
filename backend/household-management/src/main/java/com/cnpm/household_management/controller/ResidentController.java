package com.cnpm.household_management.controller;

import com.cnpm.household_management.model.Resident;
import com.cnpm.household_management.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("v1/api")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @GetMapping("/resident/{id}")
    public ResponseEntity<Resident> getResident(@PathVariable String id) {
        Optional<Resident> resident = residentService.readResident(id);
        return resident.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
