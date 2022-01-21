package com.imovie.modules.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.domain.Banner;
import com.imovie.modules.service.dto.BannerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BannerMapper extends BaseMapper<BannerDto, Banner> {
}
