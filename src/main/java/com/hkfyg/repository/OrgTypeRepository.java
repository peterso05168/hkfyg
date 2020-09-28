package com.hkfyg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.OrgType;

@Transactional
public interface OrgTypeRepository extends JpaRepository<OrgType, Long> {

}