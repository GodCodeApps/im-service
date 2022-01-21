package com.imovie.modules.config.service.impl;

import com.imovie.modules.config.domain.MoviesAreaConfig;
import com.imovie.modules.config.domain.MoviesChannelConfig;
import com.imovie.modules.config.domain.MoviesYearConfig;
import com.imovie.modules.config.repository.MoviesAreaConfigRepository;
import com.imovie.modules.config.repository.MoviesChannelConfigRepository;
import com.imovie.modules.config.repository.MoviesYearConfigRepository;
import com.imovie.modules.config.service.MoviesConfigService;
import com.imovie.modules.config.service.dto.MoviesConfigQueryCriteria;
import com.imovie.modules.config.service.mapper.MoviesAreaConfigMapper;
import com.imovie.modules.config.service.mapper.MoviesChannelConfigMapper;
import com.imovie.modules.config.service.mapper.MoviesYearConfigMapper;
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

import java.util.HashMap;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "movieConfig")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MoviesConfigServiceImpl implements MoviesConfigService {

    @Autowired
    private MoviesAreaConfigRepository areaRepository;
    @Autowired
    private MoviesChannelConfigRepository channelRepository;
    @Autowired
    private MoviesYearConfigRepository yearRepository;
    @Autowired
    private MoviesAreaConfigMapper areaConfigMapper;
    @Autowired
    private MoviesChannelConfigMapper channelConfigMapper;
    @Autowired
    private MoviesYearConfigMapper yearConfigMapper;

    @Override
    public Map<String, Object> queryAllConfig(MoviesConfigQueryCriteria criteria) {
        Pageable pageable = PageRequest.of(0, 100, Sort.by(Sort.Order.asc("id")));
        Page<MoviesAreaConfig> areaPage = areaRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        Page<MoviesChannelConfig> channelPage = channelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        Page<MoviesYearConfig> yearPage = yearRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);

        Map<String, Object> map = new HashMap<>();
        map.put("area", areaPage.getContent());
        map.put("channel", channelPage.getContent());
        map.put("year", yearPage.getContent());
        return ResultUtil.put(map);
    }

    @Override
    public Map<String, Object> queryAllArea(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Page<MoviesAreaConfig> page = areaRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(areaConfigMapper::toDto));
    }

    @Override
    public Map<String, Object> queryAllChannel(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Page<MoviesChannelConfig> page = channelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(channelConfigMapper::toDto));
    }

    @Override
    public Map<String, Object> queryAllYear(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Page<MoviesYearConfig> page = yearRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(yearConfigMapper::toDto));
    }

    @Override
    public void saveArea(MoviesAreaConfig config) {
        areaRepository.save(config);
    }

    @Override
    public void editArea(MoviesAreaConfig config) {
        areaRepository.save(config);
    }

    @Override
    public void deleteArea(Long id) {
        areaRepository.deleteById(id);
    }

    @Override
    public void saveChannel(MoviesChannelConfig config) {
        channelRepository.save(config);
    }

    @Override
    public void editChannel(MoviesChannelConfig config) {
        channelRepository.save(config);
    }

    @Override
    public void deleteChannel(Long id) {
        channelRepository.deleteById(id);
    }

    @Override
    public void saveYear(MoviesYearConfig config) {
        yearRepository.save(config);
    }

    @Override
    public void editYear(MoviesYearConfig config) {
        yearRepository.save(config);
    }

    @Override
    public void deleteYear(Long id) {
        yearRepository.deleteById(id);
    }
}
