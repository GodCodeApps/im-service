package com.imovie.modules.movie.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

@Data
public class MovieHotQueryCriteria extends MovieQueryCriteria{

    @Query(type = Query.Type.EQUAL)
    private Boolean hot = true;
}
