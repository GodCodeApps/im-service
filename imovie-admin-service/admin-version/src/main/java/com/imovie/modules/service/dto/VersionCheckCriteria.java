package com.imovie.modules.service.dto;

import com.imovie.annotation.Query;
import lombok.Data;

@Data
public class VersionCheckCriteria {

    @Query
    private Boolean enabled = true;
}
