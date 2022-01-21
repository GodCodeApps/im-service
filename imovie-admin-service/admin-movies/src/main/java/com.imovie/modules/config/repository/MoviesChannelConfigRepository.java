package com.imovie.modules.config.repository;

import com.imovie.modules.config.domain.MoviesChannelConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MoviesChannelConfigRepository extends JpaRepository<MoviesChannelConfig, Long>, JpaSpecificationExecutor<MoviesChannelConfig> {
}
