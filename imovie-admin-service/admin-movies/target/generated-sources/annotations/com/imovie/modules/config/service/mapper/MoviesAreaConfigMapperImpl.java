package com.imovie.modules.config.service.mapper;

import com.imovie.modules.config.domain.MoviesAreaConfig;
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
public class MoviesAreaConfigMapperImpl implements MoviesAreaConfigMapper {

    @Override
    public MoviesAreaConfig toEntity(MoviesConfigDto dto) {
        if ( dto == null ) {
            return null;
        }

        MoviesAreaConfig moviesAreaConfig = new MoviesAreaConfig();

        moviesAreaConfig.setId( dto.getId() );
        moviesAreaConfig.setTitle( dto.getTitle() );
        moviesAreaConfig.setType( dto.getType() );
        List<String> list = dto.getTypeList();
        if ( list != null ) {
            moviesAreaConfig.setTypeList( new ArrayList<String>( list ) );
        }
        else {
            moviesAreaConfig.setTypeList( null );
        }

        return moviesAreaConfig;
    }

    @Override
    public MoviesConfigDto toDto(MoviesAreaConfig entity) {
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
    public List<MoviesAreaConfig> toEntity(List<MoviesConfigDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MoviesAreaConfig> list = new ArrayList<MoviesAreaConfig>( dtoList.size() );
        for ( MoviesConfigDto moviesConfigDto : dtoList ) {
            list.add( toEntity( moviesConfigDto ) );
        }

        return list;
    }

    @Override
    public List<MoviesConfigDto> toDto(List<MoviesAreaConfig> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MoviesConfigDto> list = new ArrayList<MoviesConfigDto>( entityList.size() );
        for ( MoviesAreaConfig moviesAreaConfig : entityList ) {
            list.add( toDto( moviesAreaConfig ) );
        }

        return list;
    }
}
