package com.lab.cft_test_case_lab.Repository;

import com.lab.cft_test_case_lab.Model.Entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor,Long> {
}
