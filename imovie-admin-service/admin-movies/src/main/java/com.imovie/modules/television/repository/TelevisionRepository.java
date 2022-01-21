package com.imovie.modules.television.repository;

import com.imovie.modules.television.domain.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author admin
* @date 2020-03-30
*/
public interface TelevisionRepository extends JpaRepository<Television, Long>, JpaSpecificationExecutor<Television> {
}