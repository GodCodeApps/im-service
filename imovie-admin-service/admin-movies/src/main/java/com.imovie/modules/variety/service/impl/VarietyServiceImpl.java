package com.imovie.modules.variety.service.impl;

import com.imovie.modules.variety.domain.Variety;
import com.imovie.modules.variety.repository.VarietyRepository;
import com.imovie.modules.variety.service.VarietyService;
import com.imovie.modules.variety.service.dto.VarietyDto;
import com.imovie.modules.variety.service.dto.VarietyQueryCriteria;
import com.imovie.modules.variety.service.mapper.VarietyMapper;
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
//@CacheConfig(cacheNames = "variety")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class VarietyServiceImpl implements VarietyService {

    @Autowired
    private VarietyRepository varietyRepository;

    @Autowired
    private VarietyMapper varietyMapper;

    @Override
    //@Cacheable
    public Map<String, Object> queryAll(VarietyQueryCriteria criteria, Pageable pageable) {
        Page<Variety> page = varietyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(varietyMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<VarietyDto> queryAll(VarietyQueryCriteria criteria) {
        return varietyMapper.toDto(varietyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public VarietyDto findById(Long id) {
        Variety variety = varietyRepository.findById(id).orElseGet(Variety::new);
        ValidationUtil.isNull(variety.getId(), "Variety", "id", id);
        return varietyMapper.toDto(variety);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public VarietyDto create(Variety resources) {
        return varietyMapper.toDto(varietyRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Variety resources) {
        Variety variety = varietyRepository.findById(resources.getId()).orElseGet(Variety::new);
        ValidationUtil.isNull(variety.getId(), "Variety", "id", resources.getId());
        variety.copy(resources);
        varietyRepository.save(variety);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(VarietyDto resources) {
        Variety variety = varietyRepository.findById(resources.getId()).orElseGet(Variety::new);
        ValidationUtil.isNull(variety.getId(), "Variety", "id", resources.getId());
        variety.copy(varietyMapper.toEntity(resources));
        varietyRepository.save(variety);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            varietyRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<VarietyDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (VarietyDto variety : all) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("片名", variety.getTitle());
            map.put("别名", variety.getAlias());
            map.put("语言", variety.getLanguage());
            map.put("封面图", variety.getCover());
            map.put("评分", variety.getRating());
            map.put("年份", variety.getYear());
            map.put("导演", variety.getDirector());
            map.put("编剧", variety.getWriter());
            map.put("主演", variety.getActors());
            map.put("类型", variety.getType());
            map.put("集数", variety.getCount());
            map.put("上映日期", variety.getReleaseDate());
            map.put("上映地区", variety.getArea());
            map.put("单集时长", variety.getDuration());
            map.put("简介", variety.getIntroduction());
            map.put("预告片", variety.getTrailer());
            map.put("是否热门 0-普通，1-热门", variety.getHot());
            map.put("是否最新 0-普通，1-最新", variety.getLatest());
            map.put("创建时间", variety.getCreateTime());
            map.put("更新时间", variety.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}