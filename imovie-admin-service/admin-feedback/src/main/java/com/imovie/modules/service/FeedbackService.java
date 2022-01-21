package com.imovie.modules.service;

import com.imovie.modules.domain.Feedback;
import com.imovie.modules.service.dto.FeedbackCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface FeedbackService {
    Map<String, Object> queryAll(FeedbackCriteria criteria, Pageable pageable);

    void add(Feedback resource);

    void delete(Long id);
}
