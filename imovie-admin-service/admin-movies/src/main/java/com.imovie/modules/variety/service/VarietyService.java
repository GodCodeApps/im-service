package com.imovie.modules.variety.service;

import com.imovie.modules.variety.domain.Variety;
import com.imovie.modules.variety.service.dto.VarietyDto;
import com.imovie.modules.variety.service.dto.VarietyQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @author admin
* @date 2020-03-30
*/
public interface VarietyService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(VarietyQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<VarietyDto>
    */
    List<VarietyDto> queryAll(VarietyQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return VarietyDto
     */
    VarietyDto findById(Long id);

    /**
    * 创建
    * @param resources /
    * @return VarietyDto
    */
    VarietyDto create(Variety resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(Variety resources);

    void update(VarietyDto resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Long[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<VarietyDto> all, HttpServletResponse response) throws IOException;
}