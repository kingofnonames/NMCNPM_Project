package com.cnpm.household_management.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Import Entity Resident
import org.springframework.stereotype.Repository;

import com.cnpm.household_management.model.Resident;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    /**
     * KIỂM TRA ĐIỀU KIỆN TIÊN QUYẾT:
     * Phương thức này kiểm tra xem một residentId có tồn tại trong
     * bảng sổ đăng ký cư dân (Resident) hay không.
     * * Spring Data JPA sẽ tự động triển khai phương thức này.
     */
    boolean existsByResidentId(String residentId);
    
    // Lưu ý: Giả định Entity Resident của bạn có trường "residentId" (kiểu String).
}
