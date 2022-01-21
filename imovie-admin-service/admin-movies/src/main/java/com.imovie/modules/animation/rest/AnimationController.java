package com.imovie.modules.animation.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.animation.domain.Animation;
import com.imovie.modules.animation.service.AnimationService;
import com.imovie.modules.animation.service.dto.AnimationDto;
import com.imovie.modules.animation.service.dto.AnimationHotQueryCriteria;
import com.imovie.modules.animation.service.dto.AnimationLatestQueryCriteria;
import com.imovie.modules.animation.service.dto.AnimationQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @date 2020-03-30
 */
@Api(tags = "影视：动漫管理")
@RestController
@RequestMapping("/api/animation")
public class AnimationController {

    @Autowired
    private AnimationService animationService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('animation:list')")
    public void download(HttpServletResponse response, AnimationQueryCriteria criteria) throws IOException {
        animationService.download(animationService.queryAll(criteria), response);
    }

    @AnonymousAccess
    @GetMapping("/all")
    @Log("查询api/animation")
    @ApiOperation("查询api/animation")
    @PreAuthorize("@el.check('animation:list')")
    public ResponseEntity<Object> getAnimations(AnimationQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(animationService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/latest")
    @Log("查询最新api/animation")
    @ApiOperation("查询最新api/animation")
    @PreAuthorize("@el.check('animation:list')")
    public ResponseEntity<Object> getLatestAnimations(AnimationLatestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(animationService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/hot")
    @Log("查询热门api/animation")
    @ApiOperation("查询热门api/animation")
    @PreAuthorize("@el.check('animation:list')")
    public ResponseEntity<Object> getHotAnimations(AnimationHotQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(animationService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增api/animation")
    @ApiOperation("新增api/animation")
    @PreAuthorize("@el.check('animation:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Animation resources) {
        return new ResponseEntity<>(animationService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改api/animation")
    @ApiOperation("修改api/animation")
    @PreAuthorize("@el.check('animation:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Animation resources) {
        animationService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除api/animation")
    @ApiOperation("删除api/animation")
    @PreAuthorize("@el.check('animation:del')")
    @DeleteMapping(value = "/{type}")
    public ResponseEntity<Object> deleteAll(@PathVariable String type, @RequestBody Long[] ids) {
        for (Long id : ids) {
            //最新、热门、全部动漫
            if ("latest".equals(type) || "hot".equals(type)) {
                AnimationDto animation = animationService.findById(id);
                //取消最新
                if ("latest".equals(type))
                    animation.setLatest(false);

                    // 取消热门
                else
                    animation.setHot(false);

                animationService.update(animation);
            }

            //删除
            else {
                animationService.deleteAll(new Long[]{id});
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}