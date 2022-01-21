package com.imovie.modules.movie.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class MovieQueryCriteria {

    @Query(blurry = "title")
    private String blurry;

    @Query(type = Query.Type.EQUAL)
    private Long id;

    @Query(type = Query.Type.INNER_LIKE)
    private String title;

    @Query(type = Query.Type.INNER_LIKE)
    private String type;

    @Query(type = Query.Type.INNER_LIKE)
    private String area;

    @Query(type = Query.Type.INNER_LIKE)
    private String year;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> updateTime;
}
