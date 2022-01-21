package com.imovie.modules.service.impl;

import com.imovie.modules.domain.Banner;
import com.imovie.modules.repository.BannerRepository;
import com.imovie.modules.service.BannerService;
import com.imovie.modules.service.dto.BannerCriteria;
import com.imovie.modules.service.dto.BannerEnabledCriteria;
import com.imovie.modules.service.mapper.BannerMapper;
import com.imovie.utils.PageUtil;
import com.imovie.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@CacheConfig(cacheNames = "banner")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public Map<String, Object> queryAll(BannerCriteria criteria, Pageable pageable) {
        Page<Banner> page = bannerRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(bannerMapper::toDto));
    }

    @Override
    public Map<String, Object> queryEnabledAll(BannerEnabledCriteria criteria) {
        Page<Banner> page = bannerRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), Pageable.unpaged());
        return PageUtil.toPage(page.map(bannerMapper::toDto));
    }

    @Override
    public void add(Banner banner) {
        bannerRepository.save(banner);
    }

    @Override
    public void edit(Banner banner) {
        bannerRepository.save(banner);
    }

    @Override
    public void delete(Long id) {
        bannerRepository.deleteById(id);
    }
}
