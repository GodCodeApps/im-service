package com.imovie.modules.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class FeedbackCriteria {

    @Query(blurry = "content")
    private String content;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
