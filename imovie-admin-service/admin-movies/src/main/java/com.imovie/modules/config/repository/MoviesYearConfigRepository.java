package com.imovie.modules.config.repository;

import com.imovie.modules.config.domain.MoviesYearConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MoviesYearConfigRepository extends JpaRepository<MoviesYearConfig, Long>, JpaSpecificationExecutor<MoviesYearConfig> {
}
