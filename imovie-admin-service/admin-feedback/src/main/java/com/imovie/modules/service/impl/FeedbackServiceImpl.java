package com.imovie.modules.service.impl;

import com.imovie.modules.domain.Feedback;
import com.imovie.modules.repository.FeedbackRepository;
import com.imovie.modules.service.FeedbackService;
import com.imovie.modules.service.dto.FeedbackCriteria;
import com.imovie.modules.service.mapper.FeedbackMapper;
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
@CacheConfig(cacheNames = "feedback")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public Map<String, Object> queryAll(FeedbackCriteria criteria, Pageable pageable) {
        Page<Feedback> page = feedbackRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, criteria, cb), pageable);
        return PageUtil.toPage(page.map(feedbackMapper::toDto));
    }

    @Override
    public void add(Feedback resource) {
        feedbackRepository.save(resource);
    }

    @Override
    public void delete(Long id) {
        feedbackRepository.deleteById(id);
    }
}
