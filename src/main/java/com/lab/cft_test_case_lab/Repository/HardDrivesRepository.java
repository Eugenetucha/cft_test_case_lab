package com.lab.cft_test_case_lab.Repository;

import com.lab.cft_test_case_lab.Model.Entity.HardDrives;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardDrivesRepository extends JpaRepository<HardDrives,Long> {
}
