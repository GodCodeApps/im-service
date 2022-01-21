package com.imovie.modules.service;

import com.imovie.modules.domain.Version;
import com.imovie.modules.service.dto.VersionCheckCriteria;
import com.imovie.modules.service.dto.VersionCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface VersionService {

    Map<String, Object> queryAll(VersionCriteria criteria, Pageable pageable);

    Map<String,Object> checkVersion(VersionCheckCriteria checkCriteria);

    void add(Version version);

    void edit(Version version);

    void delete(Long id);
}
