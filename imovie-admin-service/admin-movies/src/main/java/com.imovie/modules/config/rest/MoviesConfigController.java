package com.imovie.modules.config.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.config.domain.MoviesAreaConfig;
import com.imovie.modules.config.domain.MoviesChannelConfig;
import com.imovie.modules.config.domain.MoviesYearConfig;
import com.imovie.modules.config.service.MoviesConfigService;
import com.imovie.modules.config.service.dto.MoviesConfigQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "影视：地区、分类、年代配置信息")
@RequestMapping("api/movies/config")
@RestController
public class MoviesConfigController {

    @Autowired
    private MoviesConfigService movieConfigService;

    @AnonymousAccess
    @Log("查询影视全部配置(地区、分类、年代)")
    @ApiOperation("查询影视全部配置(地区、分类、年代)")
    @GetMapping
    public ResponseEntity<Object> getConfig(MoviesConfigQueryCriteria criteria) {
        return ResponseEntity.ok(movieConfigService.queryAllConfig(criteria));
    }

    @AnonymousAccess
    @Log("查询影视全部地区")
    @ApiOperation("查询影视全部地区")
    @GetMapping(value = "/area")
    public ResponseEntity<Object> getAreaList(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("id")));
        return ResponseEntity.ok(movieConfigService.queryAllArea(criteria,page));
    }

    @Log("新增地区")
    @ApiOperation("新增地区")
    @PostMapping("/area")
    public ResponseEntity<Object> addArea(@RequestBody MoviesAreaConfig config) {
        config.updateType();
        movieConfigService.saveArea(config);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("编辑地区")
    @ApiOperation("编辑地区")
    @PutMapping("/area")
    public ResponseEntity<Object> editArea(@RequestBody MoviesAreaConfig config) {
        config.updateType();
        movieConfigService.saveArea(config);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除地区")
    @ApiOperation("删除地区")
    @DeleteMapping("/area")
    public ResponseEntity<Object> deleteArea(@RequestBody Long id) {
        movieConfigService.deleteArea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询影视全部分类")
    @ApiOperation("查询影视全部分类")
    @GetMapping(value = "/channel")
    public ResponseEntity<Object> getChannelList(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("id")));
        return ResponseEntity.ok(movieConfigService.queryAllChannel(criteria, page));
    }


    @Log("新增分类")
    @ApiOperation("新增分类")
    @PostMapping("/channel")
    public ResponseEntity<Object> addChannel(@RequestBody MoviesChannelConfig config) {
        config.updateType();
        movieConfigService.saveChannel(config);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("编辑分类")
    @ApiOperation("编辑分类")
    @PutMapping("/channel")
    public ResponseEntity<Object> editChannel(@RequestBody MoviesChannelConfig config) {
        config.updateType();
        movieConfigService.saveChannel(config);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除分类")
    @ApiOperation("删除分类")
    @DeleteMapping("/channel")
    public ResponseEntity<Object> deleteChannel(@RequestBody Long id) {
        movieConfigService.deleteChannel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询影视全部年代")
    @ApiOperation("查询影视全部年代")
    @GetMapping(value = "/year")
    public ResponseEntity<Object> getYearList(MoviesConfigQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("id")));
        return ResponseEntity.ok(movieConfigService.queryAllYear(criteria, page));
    }

    @Log("新增年代")
    @ApiOperation("新增年代")
    @PostMapping("/year")
    public ResponseEntity<Object> addYear(@RequestBody MoviesYearConfig config) {
        config.updateType();
        movieConfigService.saveYear(config);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("编辑年代")
    @ApiOperation("编辑年代")
    @PutMapping("/year")
    public ResponseEntity<Object> editYear(@RequestBody MoviesYearConfig config) {
        config.updateType();
        movieConfigService.saveYear(config);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("删除年代")
    @ApiOperation("删除年代")
    @DeleteMapping("/year")
    public ResponseEntity<Object> deleteYear(@RequestBody Long id) {
        movieConfigService.deleteYear(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
