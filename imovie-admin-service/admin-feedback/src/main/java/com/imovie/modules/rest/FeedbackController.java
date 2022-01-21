package com.imovie.modules.rest;

import com.imovie.aop.log.Log;
import com.imovie.modules.domain.Feedback;
import com.imovie.modules.service.FeedbackService;
import com.imovie.modules.service.dto.FeedbackCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "反馈管理")
@RestController
@RequestMapping("api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Log("查询全部反馈")
    @ApiOperation("查询全部反馈")
    @GetMapping
    public ResponseEntity<Object> getFeedbackList(FeedbackCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(feedbackService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("新增用户反馈")
    @ApiOperation("新增用户反馈")
    @PostMapping
    public ResponseEntity<Object> addFeedback(@RequestBody Feedback feedback) {
        feedbackService.add(feedback);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除反馈")
    @ApiOperation("删除用户反馈")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids) {
        for (Long id :
                ids) {
            feedbackService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
