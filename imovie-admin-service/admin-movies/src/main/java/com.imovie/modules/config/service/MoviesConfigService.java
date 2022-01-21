package com.imovie.modules.config.service;

import com.imovie.modules.config.domain.MoviesAreaConfig;
import com.imovie.modules.config.domain.MoviesChannelConfig;
import com.imovie.modules.config.domain.MoviesYearConfig;
import com.imovie.modules.config.service.dto.MoviesConfigQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MoviesConfigService {

    Map<String, Object> queryAllConfig(MoviesConfigQueryCriteria criteria);

    Map<String, Object> queryAllArea(MoviesConfigQueryCriteria criteria, Pageable pageable);

    Map<String, Object> queryAllChannel(MoviesConfigQueryCriteria criteria, Pageable pageable);

    Map<String, Object> queryAllYear(MoviesConfigQueryCriteria criteria, Pageable pageable);

    void saveArea(MoviesAreaConfig config);

    void editArea(MoviesAreaConfig config);

    void deleteArea(Long id);

    void saveChannel(MoviesChannelConfig config);

    void editChannel(MoviesChannelConfig config);

    void deleteChannel(Long id);

    void saveYear(MoviesYearConfig config);

    void editYear(MoviesYearConfig config);

    void deleteYear(Long id);
}
