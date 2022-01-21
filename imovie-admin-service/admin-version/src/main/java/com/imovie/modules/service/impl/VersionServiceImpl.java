package com.imovie.modules.service.impl;

import com.imovie.modules.domain.Version;
import com.imovie.modules.repository.VersionRepository;
import com.imovie.modules.service.VersionService;
import com.imovie.modules.service.dto.VersionCheckCriteria;
import com.imovie.modules.service.dto.VersionCriteria;
import com.imovie.modules.service.mapper.VersionMapper;
import com.imovie.utils.PageUtil;
import com.imovie.utils.QueryHelp;
import com.imovie.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@CacheConfig(cacheNames = "version")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    VersionMapper versionMapper;

    @Override
    public Map<String, Object> queryAll(VersionCriteria criteria, Pageable pageable) {
        Page<Version> page = versionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(versionMapper::toDto));
    }

    @Override
    public Map<String, Object> checkVersion(VersionCheckCriteria criteria) {
        try {
            Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Order.desc("updateTime")));
            Page<Version> page = versionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
            return ResultUtil.put(versionMapper.toDto(page.getContent().get(0)));
        } catch (Exception e) {
            return ResultUtil.put(null);
        }
    }

    @Override
    public void add(Version version) {
        versionRepository.save(version);
    }

    @Override
    public void edit(Version version) {
        versionRepository.save(version);
    }

    @Override
    public void delete(Long id) {
        versionRepository.deleteById(id);
    }
}
