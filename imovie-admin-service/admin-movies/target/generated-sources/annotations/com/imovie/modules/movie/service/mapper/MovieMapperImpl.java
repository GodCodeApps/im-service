package com.imovie.modules.movie.service.mapper;

import com.imovie.modules.movie.domain.Movie;
import com.imovie.modules.movie.service.dto.MovieDto;
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
public class MovieMapperImpl implements MovieMapper {

    @Override
    public Movie toEntity(MovieDto dto) {
        if ( dto == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setId( dto.getId() );
        movie.setTitle( dto.getTitle() );
        movie.setAlias( dto.getAlias() );
        movie.setCover( dto.getCover() );
        movie.setRating( dto.getRating() );
        movie.setYear( dto.getYear() );
        movie.setArea( dto.getArea() );
        movie.setLanguage( dto.getLanguage() );
        movie.setDirector( dto.getDirector() );
        movie.setWriter( dto.getWriter() );
        movie.setActors( dto.getActors() );
        movie.setType( dto.getType() );
        movie.setReleaseDate( dto.getReleaseDate() );
        movie.setDuration( dto.getDuration() );
        movie.setIntroduction( dto.getIntroduction() );
        movie.setTrailer( dto.getTrailer() );
        movie.setRanking( dto.getRanking() );
        movie.setHot( dto.getHot() );
        movie.setLatest( dto.getLatest() );
        movie.setCreateTime( dto.getCreateTime() );
        movie.setUpdateTime( dto.getUpdateTime() );

        return movie;
    }

    @Override
    public MovieDto toDto(Movie entity) {
        if ( entity == null ) {
            return null;
        }

        MovieDto movieDto = new MovieDto();

        movieDto.setId( entity.getId() );
        movieDto.setTitle( entity.getTitle() );
        movieDto.setAlias( entity.getAlias() );
        movieDto.setCover( entity.getCover() );
        movieDto.setRating( entity.getRating() );
        movieDto.setYear( entity.getYear() );
        movieDto.setArea( entity.getArea() );
        movieDto.setLanguage( entity.getLanguage() );
        movieDto.setDirector( entity.getDirector() );
        movieDto.setWriter( entity.getWriter() );
        movieDto.setActors( entity.getActors() );
        movieDto.setType( entity.getType() );
        movieDto.setReleaseDate( entity.getReleaseDate() );
        movieDto.setDuration( entity.getDuration() );
        movieDto.setIntroduction( entity.getIntroduction() );
        movieDto.setTrailer( entity.getTrailer() );
        movieDto.setRanking( entity.getRanking() );
        movieDto.setHot( entity.getHot() );
        movieDto.setLatest( entity.getLatest() );
        movieDto.setCreateTime( entity.getCreateTime() );
        movieDto.setUpdateTime( entity.getUpdateTime() );

        return movieDto;
    }

    @Override
    public List<Movie> toEntity(List<MovieDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Movie> list = new ArrayList<Movie>( dtoList.size() );
        for ( MovieDto movieDto : dtoList ) {
            list.add( toEntity( movieDto ) );
        }

        return list;
    }

    @Override
    public List<MovieDto> toDto(List<Movie> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MovieDto> list = new ArrayList<MovieDto>( entityList.size() );
        for ( Movie movie : entityList ) {
            list.add( toDto( movie ) );
        }

        return list;
    }
}
