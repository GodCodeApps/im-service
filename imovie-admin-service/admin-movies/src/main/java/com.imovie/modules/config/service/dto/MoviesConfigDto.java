package com.imovie.modules.config.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MoviesConfigDto {

    private Long id;
    private String title;/*配置名称*/
    @JsonIgnore
    private String type;/*所属类型 0-电影、1-电视、3-动漫、4-综艺*/
    @Transient
    private List<String> typeList;

    public List<String> getTypeList() {
        if (type != null) {
            typeList = new ArrayList<>();
            typeList.addAll(Arrays.asList(type.split(",")));
        }
        return typeList;
    }
}
