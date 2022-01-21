package com.imovie.modules.animation.repository;

import com.imovie.modules.animation.domain.Animation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author admin
* @date 2020-03-30
*/
public interface AnimationRepository extends JpaRepository<Animation, Long>, JpaSpecificationExecutor<Animation> {
}