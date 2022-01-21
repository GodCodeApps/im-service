package com.imovie.modules.config.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.config.domain.MoviesChannelConfig;
import com.imovie.modules.config.service.dto.MoviesConfigDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MoviesChannelConfigMapper extends BaseMapper<MoviesConfigDto, MoviesChannelConfig> {
}
