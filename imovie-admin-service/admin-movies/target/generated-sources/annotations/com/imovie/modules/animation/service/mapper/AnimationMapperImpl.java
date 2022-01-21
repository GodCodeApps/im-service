package com.imovie.modules.animation.service.mapper;

import com.imovie.modules.animation.domain.Animation;
import com.imovie.modules.animation.service.dto.AnimationDto;
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
public class AnimationMapperImpl implements AnimationMapper {

    @Override
    public Animation toEntity(AnimationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Animation animation = new Animation();

        animation.setId( dto.getId() );
        animation.setTitle( dto.getTitle() );
        animation.setAlias( dto.getAlias() );
        animation.setLanguage( dto.getLanguage() );
        animation.setCover( dto.getCover() );
        animation.setRating( dto.getRating() );
        animation.setYear( dto.getYear() );
        animation.setDirector( dto.getDirector() );
        animation.setWriter( dto.getWriter() );
        animation.setActors( dto.getActors() );
        animation.setType( dto.getType() );
        animation.setCount( dto.getCount() );
        animation.setReleaseDate( dto.getReleaseDate() );
        animation.setArea( dto.getArea() );
        animation.setDuration( dto.getDuration() );
        animation.setIntroduction( dto.getIntroduction() );
        animation.setTrailer( dto.getTrailer() );
        animation.setHot( dto.getHot() );
        animation.setLatest( dto.getLatest() );
        animation.setCreateTime( dto.getCreateTime() );
        animation.setUpdateTime( dto.getUpdateTime() );

        return animation;
    }

    @Override
    public AnimationDto toDto(Animation entity) {
        if ( entity == null ) {
            return null;
        }

        AnimationDto animationDto = new AnimationDto();

        animationDto.setId( entity.getId() );
        animationDto.setTitle( entity.getTitle() );
        animationDto.setAlias( entity.getAlias() );
        animationDto.setLanguage( entity.getLanguage() );
        animationDto.setCover( entity.getCover() );
        animationDto.setRating( entity.getRating() );
        animationDto.setYear( entity.getYear() );
        animationDto.setDirector( entity.getDirector() );
        animationDto.setWriter( entity.getWriter() );
        animationDto.setActors( entity.getActors() );
        animationDto.setType( entity.getType() );
        animationDto.setCount( entity.getCount() );
        animationDto.setReleaseDate( entity.getReleaseDate() );
        animationDto.setArea( entity.getArea() );
        animationDto.setDuration( entity.getDuration() );
        animationDto.setIntroduction( entity.getIntroduction() );
        animationDto.setTrailer( entity.getTrailer() );
        animationDto.setHot( entity.getHot() );
        animationDto.setLatest( entity.getLatest() );
        animationDto.setCreateTime( entity.getCreateTime() );
        animationDto.setUpdateTime( entity.getUpdateTime() );

        return animationDto;
    }

    @Override
    public List<Animation> toEntity(List<AnimationDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Animation> list = new ArrayList<Animation>( dtoList.size() );
        for ( AnimationDto animationDto : dtoList ) {
            list.add( toEntity( animationDto ) );
        }

        return list;
    }

    @Override
    public List<AnimationDto> toDto(List<Animation> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AnimationDto> list = new ArrayList<AnimationDto>( entityList.size() );
        for ( Animation animation : entityList ) {
            list.add( toDto( animation ) );
        }

        return list;
    }
}
