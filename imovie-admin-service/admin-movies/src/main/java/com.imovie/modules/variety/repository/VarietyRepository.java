package com.imovie.modules.variety.repository;

import com.imovie.modules.variety.domain.Variety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author admin
* @date 2020-03-30
*/
public interface VarietyRepository extends JpaRepository<Variety, Long>, JpaSpecificationExecutor<Variety> {
}