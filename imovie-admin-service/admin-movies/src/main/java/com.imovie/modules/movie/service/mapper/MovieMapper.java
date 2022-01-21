package com.imovie.modules.movie.service.mapper;

import com.imovie.base.BaseMapper;
import com.imovie.modules.movie.domain.Movie;
import com.imovie.modules.movie.service.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper extends BaseMapper<MovieDto, Movie> {
}
