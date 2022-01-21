package com.imovie.modules.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class VersionCriteria {

    @Query(blurry = "title,content")
    private String blurry;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}
