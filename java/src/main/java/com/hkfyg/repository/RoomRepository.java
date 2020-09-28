package com.hkfyg.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.Room;

 
@Transactional
public interface RoomRepository extends JpaRepository<Room, Long>{  

}