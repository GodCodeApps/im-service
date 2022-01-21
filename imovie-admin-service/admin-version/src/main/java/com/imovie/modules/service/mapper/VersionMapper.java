package com.imovie.modules.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.domain.Version;
import com.imovie.modules.service.dto.VersionDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VersionMapper extends BaseMapper<VersionDto, Version> {
}
