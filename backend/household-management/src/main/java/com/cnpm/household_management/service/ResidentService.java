package com.cnpm.household_management.service;

import com.cnpm.household_management.model.Resident;
import com.cnpm.household_management.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResidentService {
    @Autowired ResidentRepository residentRepository;


    public Resident createResident(Resident resident) throws Exception {
        if (residentRepository.existsByResidentId(resident.getResidentId())){
            throw new Exception("Resident ID " + resident.getResidentId() + " exists!");
        }

        return residentRepository.save(resident);
    }

    public Optional<Resident> readResident(String residentId) {
        return residentRepository.findByResidentId(residentId);
    }

    public Resident updateResident(Resident resident) {
        if (!residentRepository.existsByResidentId(resident.getResidentId())) {
            throw new RuntimeException("Resident ID " + resident.getResidentId() + " does not exist!");
        }

        return residentRepository.save(resident);
    }

    public void deleteResident(String residentId) {
        residentRepository.deleteByResidentID(residentId);
    }
}
