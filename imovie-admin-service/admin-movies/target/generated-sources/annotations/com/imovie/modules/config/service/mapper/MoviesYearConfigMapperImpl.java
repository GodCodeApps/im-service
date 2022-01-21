package com.imovie.modules.config.service.mapper;

import com.imovie.modules.config.domain.MoviesYearConfig;
import com.imovie.modules.config.service.dto.MoviesConfigDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T11:06:39+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_312 (Amazon.com Inc.)"
)
@Component
public class MoviesYearConfigMapperImpl implements MoviesYearConfigMapper {

    @Override
    public MoviesYearConfig toEntity(MoviesConfigDto dto) {
        if ( dto == null ) {
            return null;
        }

        MoviesYearConfig moviesYearConfig = new MoviesYearConfig();

        moviesYearConfig.setId( dto.getId() );
        moviesYearConfig.setTitle( dto.getTitle() );
        moviesYearConfig.setType( dto.getType() );
        List<String> list = dto.getTypeList();
        if ( list != null ) {
            moviesYearConfig.setTypeList( new ArrayList<String>( list ) );
        }
        else {
            moviesYearConfig.setTypeList( null );
        }

        return moviesYearConfig;
    }

    @Override
    public MoviesConfigDto toDto(MoviesYearConfig entity) {
        if ( entity == null ) {
            return null;
        }

        MoviesConfigDto moviesConfigDto = new MoviesConfigDto();

        moviesConfigDto.setId( entity.getId() );
        moviesConfigDto.setTitle( entity.getTitle() );
        moviesConfigDto.setType( entity.getType() );
        List<String> list = entity.getTypeList();
        if ( list != null ) {
            moviesConfigDto.setTypeList( new ArrayList<String>( list ) );
        }
        else {
            moviesConfigDto.setTypeList( null );
        }

        return moviesConfigDto;
    }

    @Override
    public List<MoviesYearConfig> toEntity(List<MoviesConfigDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MoviesYearConfig> list = new ArrayList<MoviesYearConfig>( dtoList.size() );
        for ( MoviesConfigDto moviesConfigDto : dtoList ) {
            list.add( toEntity( moviesConfigDto ) );
        }

        return list;
    }

    @Override
    public List<MoviesConfigDto> toDto(List<MoviesYearConfig> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MoviesConfigDto> list = new ArrayList<MoviesConfigDto>( entityList.size() );
        for ( MoviesYearConfig moviesYearConfig : entityList ) {
            list.add( toDto( moviesYearConfig ) );
        }

        return list;
    }
}
