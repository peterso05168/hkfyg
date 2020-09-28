package com.hkfyg.repository;
 
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.PublicHoliday;

 
@Transactional
public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, Long>{  
	List<PublicHoliday> findAllByDateBetween(Date startDate, Date endDate);
}