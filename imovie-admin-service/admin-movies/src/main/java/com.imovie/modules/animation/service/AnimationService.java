package com.imovie.modules.animation.service;

import com.imovie.modules.animation.domain.Animation;
import com.imovie.modules.animation.service.dto.AnimationDto;
import com.imovie.modules.animation.service.dto.AnimationQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2020-03-30
 */
public interface AnimationService {

    /**
     * 查询数据分页
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String, Object>
     */
    Map<String, Object> queryAll(AnimationQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     *
     * @param criteria 条件参数
     * @return List<AnimationDto>
     */
    List<AnimationDto> queryAll(AnimationQueryCriteria criteria);

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return AnimationDto
     */
    AnimationDto findById(Long id);

    /**
     * 创建
     *
     * @param resources /
     * @return AnimationDto
     */
    AnimationDto create(Animation resources);

    /**
     * 编辑
     *
     * @param resources /
     */
    void update(Animation resources);

    void update(AnimationDto resources);

    /**
     * 多选删除
     *
     * @param ids /
     */
    void deleteAll(Long[] ids);

    /**
     * 导出数据
     *
     * @param all      待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<AnimationDto> all, HttpServletResponse response) throws IOException;
}