package com.imovie.modules.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.domain.Version;
import com.imovie.modules.service.VersionService;
import com.imovie.modules.service.dto.VersionCheckCriteria;
import com.imovie.modules.service.dto.VersionCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Api(tags = "APP版本管理")
@RequestMapping("api/version")
@RestController
public class VersionController {

    @Autowired
    private VersionService versionService;

    @Log("查询所有版本")
    @ApiOperation("查询所有版本")
    @GetMapping
    public ResponseEntity<Object> getVersionList(VersionCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(versionService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查检新版本")
    @ApiOperation("检查新版本")
    @GetMapping("/checkVersion")
    public ResponseEntity<Object> checkVersion(VersionCheckCriteria checkCriteria) {
        return new ResponseEntity<>(versionService.checkVersion(checkCriteria), HttpStatus.OK);
    }

    @Log("添加新版本")
    @ApiOperation("添加新版本")
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Version version) {
        versionService.add(version);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("编辑当前版本")
    @ApiOperation("编辑当前版本")
    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Version version) {
        versionService.edit(version);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除版本")
    @ApiOperation("删除版本")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids) {
        for (Long id :
                ids) {
            versionService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
