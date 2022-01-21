package com.imovie.modules.variety.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.variety.domain.Variety;
import com.imovie.modules.variety.service.VarietyService;
import com.imovie.modules.variety.service.dto.VarietyDto;
import com.imovie.modules.variety.service.dto.VarietyHotQueryCriteria;
import com.imovie.modules.variety.service.dto.VarietyLatestQueryCriteria;
import com.imovie.modules.variety.service.dto.VarietyQueryCriteria;
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
@Api(tags = "影视：综艺管理")
@RestController
@RequestMapping("/api/variety")
public class VarietyController {

    @Autowired
    private VarietyService varietyService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('variety:list')")
    public void download(HttpServletResponse response, VarietyQueryCriteria criteria) throws IOException {
        varietyService.download(varietyService.queryAll(criteria), response);
    }

    @AnonymousAccess
    @GetMapping("/all")
    @Log("查询api/variety")
    @ApiOperation("查询api/variety")
    @PreAuthorize("@el.check('variety:list')")
    public ResponseEntity<Object> getVarieties(VarietyQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(varietyService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/latest")
    @Log("查询最新api/variety")
    @ApiOperation("查询最新api/variety")
    @PreAuthorize("@el.check('variety:list')")
    public ResponseEntity<Object> getLatestVarieties(VarietyLatestQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(varietyService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @GetMapping("/hot")
    @Log("查询热门api/variety")
    @ApiOperation("查询热门api/variety")
    @PreAuthorize("@el.check('variety:list')")
    public ResponseEntity<Object> getHotVarieties(VarietyHotQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(varietyService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @PostMapping
    @Log("新增api/variety")
    @ApiOperation("新增api/variety")
    @PreAuthorize("@el.check('variety:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Variety resources) {
        return new ResponseEntity<>(varietyService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改api/variety")
    @ApiOperation("修改api/variety")
    @PreAuthorize("@el.check('variety:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Variety resources) {
        varietyService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除api/variety")
    @ApiOperation("删除api/variety")
    @PreAuthorize("@el.check('variety:del')")
    @DeleteMapping("{type}")
    public ResponseEntity<Object> deleteAll(@PathVariable String type, @RequestBody Long[] ids) {
        for (Long id : ids) {
            //最新、热门、全部动漫
            if ("latest".equals(type) || "hot".equals(type)) {
                VarietyDto varietyDto = varietyService.findById(id);
                //取消最新
                if ("latest".equals(type))
                    varietyDto.setLatest(false);

                    // 取消热门
                else
                    varietyDto.setHot(false);

                varietyService.update(varietyDto);
            }

            //删除
            else {
                varietyService.deleteAll(new Long[]{id});
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}