package com.imovie.modules.variety.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.variety.domain.Variety;
import com.imovie.modules.variety.service.dto.VarietyDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author admin
* @date 2020-03-30
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VarietyMapper extends BaseMapper<VarietyDto, Variety> {

}