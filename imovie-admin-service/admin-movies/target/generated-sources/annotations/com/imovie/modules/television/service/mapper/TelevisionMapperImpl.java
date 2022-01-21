package com.imovie.modules.television.service.mapper;

import com.imovie.modules.television.domain.Television;
import com.imovie.modules.television.service.dto.TelevisionDto;
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
public class TelevisionMapperImpl implements TelevisionMapper {

    @Override
    public Television toEntity(TelevisionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Television television = new Television();

        television.setId( dto.getId() );
        television.setTitle( dto.getTitle() );
        television.setAlias( dto.getAlias() );
        television.setLanguage( dto.getLanguage() );
        television.setCover( dto.getCover() );
        television.setRating( dto.getRating() );
        television.setYear( dto.getYear() );
        television.setDirector( dto.getDirector() );
        television.setWriter( dto.getWriter() );
        television.setActors( dto.getActors() );
        television.setType( dto.getType() );
        television.setCount( dto.getCount() );
        television.setReleaseDate( dto.getReleaseDate() );
        television.setArea( dto.getArea() );
        television.setDuration( dto.getDuration() );
        television.setIntroduction( dto.getIntroduction() );
        television.setTrailer( dto.getTrailer() );
        television.setHot( dto.getHot() );
        television.setLatest( dto.getLatest() );
        television.setCreateTime( dto.getCreateTime() );
        television.setUpdateTime( dto.getUpdateTime() );

        return television;
    }

    @Override
    public TelevisionDto toDto(Television entity) {
        if ( entity == null ) {
            return null;
        }

        TelevisionDto televisionDto = new TelevisionDto();

        televisionDto.setId( entity.getId() );
        televisionDto.setTitle( entity.getTitle() );
        televisionDto.setAlias( entity.getAlias() );
        televisionDto.setLanguage( entity.getLanguage() );
        televisionDto.setCover( entity.getCover() );
        televisionDto.setRating( entity.getRating() );
        televisionDto.setYear( entity.getYear() );
        televisionDto.setDirector( entity.getDirector() );
        televisionDto.setWriter( entity.getWriter() );
        televisionDto.setActors( entity.getActors() );
        televisionDto.setType( entity.getType() );
        televisionDto.setCount( entity.getCount() );
        televisionDto.setReleaseDate( entity.getReleaseDate() );
        televisionDto.setArea( entity.getArea() );
        televisionDto.setDuration( entity.getDuration() );
        televisionDto.setIntroduction( entity.getIntroduction() );
        televisionDto.setTrailer( entity.getTrailer() );
        televisionDto.setHot( entity.getHot() );
        televisionDto.setLatest( entity.getLatest() );
        televisionDto.setCreateTime( entity.getCreateTime() );
        televisionDto.setUpdateTime( entity.getUpdateTime() );

        return televisionDto;
    }

    @Override
    public List<Television> toEntity(List<TelevisionDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Television> list = new ArrayList<Television>( dtoList.size() );
        for ( TelevisionDto televisionDto : dtoList ) {
            list.add( toEntity( televisionDto ) );
        }

        return list;
    }

    @Override
    public List<TelevisionDto> toDto(List<Television> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TelevisionDto> list = new ArrayList<TelevisionDto>( entityList.size() );
        for ( Television television : entityList ) {
            list.add( toDto( television ) );
        }

        return list;
    }
}
