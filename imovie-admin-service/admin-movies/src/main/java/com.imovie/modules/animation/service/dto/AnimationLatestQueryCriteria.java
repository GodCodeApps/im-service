package com.imovie.modules.animation.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

/**
* @author admin
* @date 2020-03-30
*/
@Data
public class AnimationLatestQueryCriteria extends AnimationQueryCriteria {

    @Query(type = Query.Type.EQUAL)
    private Boolean latest = true;
}