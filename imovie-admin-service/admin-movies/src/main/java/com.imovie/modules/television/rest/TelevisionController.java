package com.imovie.modules.television.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.television.domain.Television;
import com.imovie.modules.television.service.TelevisionService;
import com.imovie.modules.television.service.dto.TelevisionDto;
import com.imovie.modules.television.service.dto.TelevisionHotQueryCriteria;
import com.imovie.modules.television.service.dto.TelevisionLatestQueryCriteria;
import com.imovie.modules.television.service.dto.TelevisionQueryCriteria;
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
@Api(tags = "影视：电视管理")
@RestController
@RequestMapping("/api/television")
public class TelevisionController {

    @Autowired
    private TelevisionService televisionService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('television:list')")
    public void download(HttpServletResponse response, TelevisionQueryCriteria criteria) throws IOException {
        televisionService.download(televisionService.queryAll(criteria), response);
    }

    @AnonymousAccess
    @GetMapping("/all")
    @Log("查询api/television")
    @ApiOperation("查询api/television")
    @PreAuthorize("@el.check('television:list')")
    public ResponseEntity<Object> getTelevisions(TelevisionQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(televisionService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/latest")
    @Log("查询最新api/television")
    @ApiOperation("查询最新api/television")
    @PreAuthorize("@el.check('television:list')")
    public ResponseEntity<Object> getLatestTelevisions(TelevisionLatestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(televisionService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/hot")
    @Log("查询热门api/television")
    @ApiOperation("查询热门api/television")
    @PreAuthorize("@el.check('television:list')")
    public ResponseEntity<Object> getHotTelevisions(TelevisionHotQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(televisionService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增api/television")
    @ApiOperation("新增api/television")
    @PreAuthorize("@el.check('television:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Television resources) {
        return new ResponseEntity<>(televisionService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改api/television")
    @ApiOperation("修改api/television")
    @PreAuthorize("@el.check('television:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Television resources) {
        televisionService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除api/television")
    @ApiOperation("删除api/television")
    @PreAuthorize("@el.check('television:del')")
    @DeleteMapping("{type}")
    public ResponseEntity<Object> deleteAll(@PathVariable String type, @RequestBody Long[] ids) {
        for (Long id : ids) {
            //最新、热门、全部动漫
            if ("latest".equals(type) || "hot".equals(type)) {
                TelevisionDto televisionDto = televisionService.findById(id);
                //取消最新
                if ("latest".equals(type))
                    televisionDto.setLatest(false);

                    // 取消热门
                else
                    televisionDto.setHot(false);

                televisionService.update(televisionDto);
            }

            //删除
            else {
                televisionService.deleteAll(new Long[]{id});
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}