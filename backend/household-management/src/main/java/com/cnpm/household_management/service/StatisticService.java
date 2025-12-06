package com.cnpm.household_management.service;

import com.cnpm.household_management.dto.StatisticResponse;
import com.cnpm.household_management.dto.StatisticRequest;
import com.cnpm.household_management.model.Resident;
import com.cnpm.household_management.repository.ResidentRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private ResidentRepository residentRepository;

    public StatisticResponse filterResidents(StatisticRequest request) {
        Specification<Resident> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // -- Lọc theo Mã hộ khẩu (LIKE %...%) --
            if (request.getHouseholdBookID() != null && !request.getHouseholdBookID().isBlank()) {
                predicates.add(cb.like(root.get("householdBookID"), "%" + request.getHouseholdBookID() + "%"));
            }

            // -- Lọc theo Tên (LIKE %...%) --
            if (request.getFullName() != null && !request.getFullName().isBlank()) {
                predicates.add(cb.like(root.get("fullName"), "%" + request.getFullName() + "%"));
            }

            // -- Lọc theo Quê quán --
            if (request.getHometown() != null && !request.getHometown().isBlank()) {
                predicates.add(cb.like(root.get("hometown"), "%" + request.getHometown() + "%"));
            }

            // -- Lọc theo Dân tộc --
            if (request.getEthnicity() != null && !request.getEthnicity().isBlank()) {
                predicates.add(cb.like(root.get("ethnicity"), "%" + request.getEthnicity() + "%"));
            }

            // -- Lọc theo Nghề nghiệp --
            if (request.getOccupation() != null && !request.getOccupation().isBlank()) {
                predicates.add(cb.like(root.get("occupation"), "%" + request.getOccupation() + "%"));
            }

            // -- Lọc theo Trạng thái sống/chết --
            if (request.getIsDead() != null) {
                predicates.add(cb.equal(root.get("isDead"), request.getIsDead()));
            }

            // -- Lọc theo Độ tuổi (Tính toán dựa trên ngày sinh) --
            LocalDate now = LocalDate.now();

            if (request.getMinAge() != null) {
                LocalDate maxDob = now.minusYears(request.getMinAge());
                predicates.add(cb.lessThanOrEqualTo(root.get("dateOfBirth"), maxDob));
            }

            if (request.getMaxAge() != null) {
                LocalDate minDob = now.minusYears(request.getMaxAge() + 1);
                predicates.add(cb.greaterThan(root.get("dateOfBirth"), minDob));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        List<Resident> resultList = residentRepository.findAll(spec);

        return new StatisticResponse(resultList.size(), resultList);
    }
}