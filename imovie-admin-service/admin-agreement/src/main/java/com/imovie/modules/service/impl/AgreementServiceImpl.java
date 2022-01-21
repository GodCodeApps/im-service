package com.imovie.modules.service.impl;

import com.imovie.modules.domain.Agreement;
import com.imovie.modules.repository.AgreementRepository;
import com.imovie.modules.service.AgreementService;
import com.imovie.modules.service.dto.AgreementDto;
import com.imovie.modules.service.dto.AgreementQueryCriteria;
import com.imovie.modules.service.mapper.AgreementMapper;
import com.imovie.utils.*;
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
 * @date 2020-03-29
 */
@Service
//@CacheConfig(cacheNames = "agreement")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;

    private final AgreementMapper agreementMapper;

    public AgreementServiceImpl(AgreementRepository agreementRepository, AgreementMapper agreementMapper) {
        this.agreementRepository = agreementRepository;
        this.agreementMapper = agreementMapper;
    }

    @Override
    //@Cacheable
    public Map<String, Object> queryAll(AgreementQueryCriteria criteria, Pageable pageable) {
        Page<Agreement> page = agreementRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(agreementMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<AgreementDto> queryAll(AgreementQueryCriteria criteria) {
        return agreementMapper.toDto(agreementRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    public Map<String, Object> queryByType(String type) {
        return ResultUtil.put(agreementMapper.toDto(agreementRepository.findAgreementByType(type)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public AgreementDto findById(Long id) {
        Agreement agreement = agreementRepository.findById(id).orElseGet(Agreement::new);
        ValidationUtil.isNull(agreement.getId(), "Agreement", "id", id);
        return agreementMapper.toDto(agreement);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public AgreementDto create(Agreement resources) {
        return agreementMapper.toDto(agreementRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Agreement resources) {
        Agreement agreement = agreementRepository.findById(resources.getId()).orElseGet(Agreement::new);
        ValidationUtil.isNull(agreement.getId(), "Agreement", "id", resources.getId());
        agreement.copy(resources);
        agreementRepository.save(agreement);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            agreementRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<AgreementDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (AgreementDto agreement : all) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("协议标题", agreement.getTitle());
            map.put("协议内容", agreement.getContent());
            map.put("协议类型 0-用户协议，1-隐私政策", agreement.getType());
            map.put("创建时间", agreement.getCreateTime());
            map.put("更新时间", agreement.getUpdateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}