package com.imovie.modules.animation.service.impl;

import com.imovie.modules.animation.domain.Animation;
import com.imovie.modules.animation.repository.AnimationRepository;
import com.imovie.modules.animation.service.AnimationService;
import com.imovie.modules.animation.service.dto.AnimationDto;
import com.imovie.modules.animation.service.dto.AnimationQueryCriteria;
import com.imovie.modules.animation.service.mapper.AnimationMapper;
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

/**
 * @author admin
 * @date 2020-03-30
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AnimationServiceImpl implements AnimationService {

    @Autowired
    private AnimationRepository animationRepository;
    @Autowired
    private AnimationMapper animationMapper;


    @Override
    public Map<String, Object> queryAll(AnimationQueryCriteria criteria, Pageable pageable) {
        Page<Animation> page = animationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(animationMapper::toDto));
    }

    @Override
    public List<AnimationDto> queryAll(AnimationQueryCriteria criteria) {
        return animationMapper.toDto(animationRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    public AnimationDto findById(Long id) {
        Animation animation = animationRepository.findById(id).orElseGet(Animation::new);
        ValidationUtil.isNull(animation.getId(), "Animation", "id", id);
        return animationMapper.toDto(animation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AnimationDto create(Animation resources) {
        return animationMapper.toDto(animationRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Animation resources) {
        Animation animation = animationRepository.findById(resources.getId()).orElseGet(Animation::new);
        ValidationUtil.isNull(animation.getId(), "Animation", "id", resources.getId());
        animation.copy(resources);
        animationRepository.save(animation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AnimationDto resources) {
        Animation animation = animationRepository.findById(resources.getId()).orElseGet(Animation::new);
        ValidationUtil.isNull(animation.getId(), "Animation", "id", resources.getId());
        animation.copy(animationMapper.toEntity(resources));
        animationRepository.save(animation);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            animationRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<AnimationDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (AnimationDto animation : all) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("片名", animation.getTitle());
            map.put("别名", animation.getAlias());
            map.put("语言", animation.getLanguage());
            map.put("封面图", animation.getCover());
            map.put("评分", animation.getRating());
            map.put("年份", animation.getYear());
            map.put("导演", animation.getDirector());
            map.put("编剧", animation.getWriter());
            map.put("主演", animation.getActors());
            map.put("类型", animation.getType());
            map.put("集数", animation.getCount());
            map.put("上映日期", animation.getReleaseDate());
            map.put("上映地区", animation.getArea());
            map.put("单集时长", animation.getDuration());
            map.put("简介", animation.getIntroduction());
            map.put("预告片", animation.getTrailer());
            map.put("是否热门 0-普通，1-热门", animation.getHot());
            map.put("是否最新 0-普通，1-最新", animation.getLatest());
            map.put("创建时间", animation.getCreateTime());
            map.put("更新时间", animation.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}