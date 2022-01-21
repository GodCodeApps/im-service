package com.imovie.modules.television.service.impl;

import com.imovie.modules.television.domain.Television;
import com.imovie.modules.television.repository.TelevisionRepository;
import com.imovie.modules.television.service.TelevisionService;
import com.imovie.modules.television.service.dto.TelevisionDto;
import com.imovie.modules.television.service.dto.TelevisionQueryCriteria;
import com.imovie.modules.television.service.mapper.TelevisionMapper;
import com.imovie.utils.FileUtil;
import com.imovie.utils.PageUtil;
import com.imovie.utils.QueryHelp;
import com.imovie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
 * @author admin
 * @date 2020-03-30
 */
@Service
//@CacheConfig(cacheNames = "television")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TelevisionServiceImpl implements TelevisionService {

    @Autowired
    private TelevisionRepository televisionRepository;

    @Autowired
    private TelevisionMapper televisionMapper;


    @Override
    //@Cacheable
    public Map<String, Object> queryAll(TelevisionQueryCriteria criteria, Pageable pageable) {
        Page<Television> page = televisionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(televisionMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<TelevisionDto> queryAll(TelevisionQueryCriteria criteria) {
        return televisionMapper.toDto(televisionRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public TelevisionDto findById(Long id) {
        Television television = televisionRepository.findById(id).orElseGet(Television::new);
        ValidationUtil.isNull(television.getId(), "Television", "id", id);
        return televisionMapper.toDto(television);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public TelevisionDto create(Television resources) {
        return televisionMapper.toDto(televisionRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Television resources) {
        Television television = televisionRepository.findById(resources.getId()).orElseGet(Television::new);
        ValidationUtil.isNull(television.getId(), "Television", "id", resources.getId());
        television.copy(resources);
        televisionRepository.save(television);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(TelevisionDto resources) {
        Television television = televisionRepository.findById(resources.getId()).orElseGet(Television::new);
        ValidationUtil.isNull(television.getId(), "Television", "id", resources.getId());
        television.copy(televisionMapper.toEntity(resources));
        televisionRepository.save(television);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            televisionRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<TelevisionDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TelevisionDto television : all) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("片名", television.getTitle());
            map.put("别名", television.getAlias());
            map.put("语言", television.getLanguage());
            map.put("封面图", television.getCover());
            map.put("评分", television.getRating());
            map.put("年份", television.getYear());
            map.put("导演", television.getDirector());
            map.put("编剧", television.getWriter());
            map.put("主演", television.getActors());
            map.put("类型", television.getType());
            map.put("集数", television.getCount());
            map.put("上映日期", television.getReleaseDate());
            map.put("上映地区", television.getArea());
            map.put("单集时长", television.getDuration());
            map.put("简介", television.getIntroduction());
            map.put("预告片", television.getTrailer());
            map.put("是否热门 0-普通，1-热门", television.getHot());
            map.put("是否最新 0-普通，1-最新", television.getLatest());
            map.put("创建时间", television.getCreateTime());
            map.put("更新时间", television.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}