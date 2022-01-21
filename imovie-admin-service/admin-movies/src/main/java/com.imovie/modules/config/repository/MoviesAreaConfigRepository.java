package com.imovie.modules.config.repository;

import com.imovie.modules.config.domain.MoviesAreaConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MoviesAreaConfigRepository extends JpaRepository<MoviesAreaConfig, Long>, JpaSpecificationExecutor<MoviesAreaConfig> {
}
