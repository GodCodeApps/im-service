package com.imovie.modules.service;

import com.imovie.modules.domain.Agreement;
import com.imovie.modules.service.dto.AgreementDto;
import com.imovie.modules.service.dto.AgreementQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @date 2020-03-29
 */
public interface AgreementService {

    /**
     * 查询数据分页
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String, Object>
     */
    Map<String, Object> queryAll(AgreementQueryCriteria criteria, Pageable pageable);

    /**
     * 根据类型查询协议
     * @param type 协议类型 0-用户协议，1-隐私政策
     * @return
     */
    Map<String,Object> queryByType(String type);

    /**
     * 查询所有数据不分页
     *
     * @param criteria 条件参数
     * @return List<AgreementDto>
     */
    List<AgreementDto> queryAll(AgreementQueryCriteria criteria);

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return AgreementDto
     */
    AgreementDto findById(Long id);

    /**
     * 创建
     *
     * @param resources /
     * @return AgreementDto
     */
    AgreementDto create(Agreement resources);

    /**
     * 编辑
     *
     * @param resources /
     */
    void update(Agreement resources);

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
    void download(List<AgreementDto> all, HttpServletResponse response) throws IOException;
}