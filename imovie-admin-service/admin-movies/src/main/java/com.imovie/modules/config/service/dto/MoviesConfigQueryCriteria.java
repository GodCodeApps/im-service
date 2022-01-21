package com.imovie.modules.config.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

@Data
public class MoviesConfigQueryCriteria {

    @Query(blurry = "title")
    private String blurry;
}
