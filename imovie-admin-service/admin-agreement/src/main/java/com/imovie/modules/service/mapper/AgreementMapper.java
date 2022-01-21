package com.imovie.modules.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.domain.Agreement;
import com.imovie.modules.service.dto.AgreementDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author admin
* @date 2020-03-29
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgreementMapper extends BaseMapper<AgreementDto, Agreement> {

}