package com.imovie.modules.config.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@Table(name = "t_movies_channel")
public class MoviesChannelConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;/*配置名称*/

    @JsonIgnore
    private String type = "";/*所属类型 0-电影、1-电视、3-动漫、4-综艺*/

    @Transient
    private List<String> typeList;

    public void updateType() {
        StringBuilder stringBuilder = new StringBuilder();
        if (typeList != null && typeList.size() > 0) {
            for (String str :
                    typeList) {
                if (str != null && !"".equals(str))
                    stringBuilder.append(str).append(",");
            }
            if (stringBuilder.length() > 1) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                type = stringBuilder.toString();
            }
        }
    }

    public List<String> getTypeList() {
        if (type != null) {
            typeList = new ArrayList<>();
            typeList.addAll(Arrays.asList(type.split(",")));
        }
        return typeList;
    }
}
