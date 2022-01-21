package com.imovie.modules.repository;

import com.imovie.modules.domain.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author admin
 * @date 2020-03-29
 */
public interface AgreementRepository extends JpaRepository<Agreement, Long>, JpaSpecificationExecutor<Agreement> {

    @Query(value = "select * from t_agreement where type = ?1", nativeQuery = true)
    Agreement findAgreementByType(String type);
}