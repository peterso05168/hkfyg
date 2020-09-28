package com.hkfyg.repository;
 
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.PeakPeriod;

 
@Transactional
public interface PeakPeriodRepository extends JpaRepository<PeakPeriod, Long>{  
	List<PeakPeriod> findAllByCampTypeAndPeakDateFromGreaterThanAndPeakDateToLessThan(String campType, Date peakDateFrom, Date peakDateTo);
}