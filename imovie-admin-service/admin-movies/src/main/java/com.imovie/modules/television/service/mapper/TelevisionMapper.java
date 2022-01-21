package com.imovie.modules.television.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.television.domain.Television;
import com.imovie.modules.television.service.dto.TelevisionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author admin
* @date 2020-03-30
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TelevisionMapper extends BaseMapper<TelevisionDto, Television> {

}