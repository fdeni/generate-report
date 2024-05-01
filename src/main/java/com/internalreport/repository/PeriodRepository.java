package com.internalreport.repository;

import com.internalreport.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
    Period findByStartDateAndEndDate(String startDate, String endDate);
}
