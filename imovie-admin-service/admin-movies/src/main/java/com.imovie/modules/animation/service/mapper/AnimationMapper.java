package com.imovie.modules.animation.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.animation.domain.Animation;
import com.imovie.modules.animation.service.dto.AnimationDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author admin
* @date 2020-03-30
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnimationMapper extends BaseMapper<AnimationDto, Animation> {

}