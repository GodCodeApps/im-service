package com.imovie.modules.service;

import com.imovie.modules.domain.Banner;
import com.imovie.modules.service.dto.BannerCriteria;
import com.imovie.modules.service.dto.BannerEnabledCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;


public interface BannerService {

    Map<String,Object> queryAll(BannerCriteria criteria, Pageable pageable);

    Map<String,Object> queryEnabledAll(BannerEnabledCriteria criteria);

    void add(Banner banner);

    void edit(Banner banner);

    void delete(Long id);
}
