package com.imovie.modules.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.domain.Banner;
import com.imovie.modules.service.BannerService;
import com.imovie.modules.service.dto.BannerCriteria;
import com.imovie.modules.service.dto.BannerEnabledCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "轮播图管理")
@RestController
@RequestMapping("api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @Log("查询全部轮播图")
    @ApiOperation("查询全部轮播图")
    @GetMapping("/all")
    public ResponseEntity<Object> getBannerList(BannerCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(bannerService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询已启用的轮播图")
    @ApiOperation("查询已启用的轮播图")
    @GetMapping
    public ResponseEntity<Object> getEnabledBannerList(BannerEnabledCriteria criteria) {
        return new ResponseEntity<>(bannerService.queryEnabledAll(criteria), HttpStatus.OK);
    }

    @Log("新增轮播图")
    @ApiOperation("新增轮播图")
    @PostMapping
    public ResponseEntity<Object> addBanner(@RequestBody Banner banner) {
        bannerService.add(banner);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("修改轮播图")
    @ApiOperation(("修改轮播图"))
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Banner banner) {
        bannerService.edit(banner);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除轮播图")
    @ApiOperation("删除轮播图")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids) {
        for (Long id :
                ids) {
            bannerService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
