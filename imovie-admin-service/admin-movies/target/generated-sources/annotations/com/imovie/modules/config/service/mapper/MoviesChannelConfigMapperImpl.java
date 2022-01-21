package com.imovie.modules.config.service.mapper;

import com.imovie.modules.config.domain.MoviesChannelConfig;
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
public class MoviesChannelConfigMapperImpl implements MoviesChannelConfigMapper {

    @Override
    public MoviesChannelConfig toEntity(MoviesConfigDto dto) {
        if ( dto == null ) {
            return null;
        }

        MoviesChannelConfig moviesChannelConfig = new MoviesChannelConfig();

        moviesChannelConfig.setId( dto.getId() );
        moviesChannelConfig.setTitle( dto.getTitle() );
        moviesChannelConfig.setType( dto.getType() );
        List<String> list = dto.getTypeList();
        if ( list != null ) {
            moviesChannelConfig.setTypeList( new ArrayList<String>( list ) );
        }
        else {
            moviesChannelConfig.setTypeList( null );
        }

        return moviesChannelConfig;
    }

    @Override
    public MoviesConfigDto toDto(MoviesChannelConfig entity) {
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
    public List<MoviesChannelConfig> toEntity(List<MoviesConfigDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MoviesChannelConfig> list = new ArrayList<MoviesChannelConfig>( dtoList.size() );
        for ( MoviesConfigDto moviesConfigDto : dtoList ) {
            list.add( toEntity( moviesConfigDto ) );
        }

        return list;
    }

    @Override
    public List<MoviesConfigDto> toDto(List<MoviesChannelConfig> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MoviesConfigDto> list = new ArrayList<MoviesConfigDto>( entityList.size() );
        for ( MoviesChannelConfig moviesChannelConfig : entityList ) {
            list.add( toDto( moviesChannelConfig ) );
        }

        return list;
    }
}
