package com.hkfyg.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hkfyg.model.entity.OtherExpensesCategory;

 
@Transactional
public interface OtherExpensesCategoryRepository extends JpaRepository<OtherExpensesCategory, Long>{  

	List<OtherExpensesCategory> findAllByTypeContainingAndCategoryContaining(String type,String category);
	
}