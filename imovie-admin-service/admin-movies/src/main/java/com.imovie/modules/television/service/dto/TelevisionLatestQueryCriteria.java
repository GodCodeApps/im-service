package com.imovie.modules.television.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

/**
 * @author admin
 * @date 2020-03-30
 */
@Data
public class TelevisionLatestQueryCriteria extends TelevisionQueryCriteria {

    @Query(type = Query.Type.EQUAL)
    private Boolean latest = true;
}