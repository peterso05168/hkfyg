package com.hkfyg.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.Bed;

 
@Transactional
public interface BedRepository extends JpaRepository<Bed, Long>{  

}