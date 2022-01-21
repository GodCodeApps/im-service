package com.imovie.modules.variety.service.mapper;

import com.imovie.modules.variety.domain.Variety;
import com.imovie.modules.variety.service.dto.VarietyDto;
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
public class VarietyMapperImpl implements VarietyMapper {

    @Override
    public Variety toEntity(VarietyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Variety variety = new Variety();

        variety.setId( dto.getId() );
        variety.setTitle( dto.getTitle() );
        variety.setAlias( dto.getAlias() );
        variety.setLanguage( dto.getLanguage() );
        variety.setCover( dto.getCover() );
        variety.setRating( dto.getRating() );
        variety.setYear( dto.getYear() );
        variety.setDirector( dto.getDirector() );
        variety.setWriter( dto.getWriter() );
        variety.setActors( dto.getActors() );
        variety.setType( dto.getType() );
        variety.setCount( dto.getCount() );
        variety.setReleaseDate( dto.getReleaseDate() );
        variety.setArea( dto.getArea() );
        variety.setDuration( dto.getDuration() );
        variety.setIntroduction( dto.getIntroduction() );
        variety.setTrailer( dto.getTrailer() );
        variety.setHot( dto.getHot() );
        variety.setLatest( dto.getLatest() );
        variety.setCreateTime( dto.getCreateTime() );
        variety.setUpdateTime( dto.getUpdateTime() );

        return variety;
    }

    @Override
    public VarietyDto toDto(Variety entity) {
        if ( entity == null ) {
            return null;
        }

        VarietyDto varietyDto = new VarietyDto();

        varietyDto.setId( entity.getId() );
        varietyDto.setTitle( entity.getTitle() );
        varietyDto.setAlias( entity.getAlias() );
        varietyDto.setLanguage( entity.getLanguage() );
        varietyDto.setCover( entity.getCover() );
        varietyDto.setRating( entity.getRating() );
        varietyDto.setYear( entity.getYear() );
        varietyDto.setDirector( entity.getDirector() );
        varietyDto.setWriter( entity.getWriter() );
        varietyDto.setActors( entity.getActors() );
        varietyDto.setType( entity.getType() );
        varietyDto.setCount( entity.getCount() );
        varietyDto.setReleaseDate( entity.getReleaseDate() );
        varietyDto.setArea( entity.getArea() );
        varietyDto.setDuration( entity.getDuration() );
        varietyDto.setIntroduction( entity.getIntroduction() );
        varietyDto.setTrailer( entity.getTrailer() );
        varietyDto.setHot( entity.getHot() );
        varietyDto.setLatest( entity.getLatest() );
        varietyDto.setCreateTime( entity.getCreateTime() );
        varietyDto.setUpdateTime( entity.getUpdateTime() );

        return varietyDto;
    }

    @Override
    public List<Variety> toEntity(List<VarietyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Variety> list = new ArrayList<Variety>( dtoList.size() );
        for ( VarietyDto varietyDto : dtoList ) {
            list.add( toEntity( varietyDto ) );
        }

        return list;
    }

    @Override
    public List<VarietyDto> toDto(List<Variety> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VarietyDto> list = new ArrayList<VarietyDto>( entityList.size() );
        for ( Variety variety : entityList ) {
            list.add( toDto( variety ) );
        }

        return list;
    }
}
