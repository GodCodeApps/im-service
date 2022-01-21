package com.imovie.modules.variety.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

/**
 * @author admin
 * @date 2020-03-30
 */
@Data
public class VarietyLatestQueryCriteria extends VarietyQueryCriteria {

    @Query(type = Query.Type.EQUAL)
    private Boolean latest = true;
}