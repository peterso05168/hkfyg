package com.hkfyg.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.RoomType;

 
@Transactional
public interface RoomTypeRepository extends JpaRepository<RoomType, Long>{  

}