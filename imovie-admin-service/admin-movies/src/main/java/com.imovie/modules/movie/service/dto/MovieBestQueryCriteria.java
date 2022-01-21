package com.imovie.modules.movie.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

@Data
public class MovieBestQueryCriteria extends MovieQueryCriteria{

    @Query(type = Query.Type.GREATER_THAN)
    private int ranking = 1;
}
