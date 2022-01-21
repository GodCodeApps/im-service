package com.imovie.modules.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.domain.Feedback;
import com.imovie.modules.service.dto.FeedbackDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FeedbackMapper extends BaseMapper<FeedbackDto, Feedback> {
}
