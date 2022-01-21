package com.imovie.modules.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.domain.Agreement;
import com.imovie.modules.service.AgreementService;
import com.imovie.modules.service.dto.AgreementQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ahor admin
 * @date 2020-03-29
 */
@Api(tags = "协议管理")
@RestController
@RequestMapping("/api/agreement")
public class AgreementController {

    private final AgreementService agreementService;

    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('agreement:list')")
    public void download(HttpServletResponse response, AgreementQueryCriteria criteria) throws IOException {
        agreementService.download(agreementService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询api/agreement")
    @ApiOperation("查询api/agreement")
    @PreAuthorize("@el.check('agreement:list')")
    public ResponseEntity<Object> getAgreements(AgreementQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(agreementService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("根据协议类型查询")
    @ApiOperation("根据协议类型查询")
    @GetMapping("/{type}")
    public ResponseEntity<Object> getAgreementByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(agreementService.queryByType(type));
    }

    @PostMapping
    @Log("新增api/agreement")
    @ApiOperation("新增api/agreement")
    @PreAuthorize("@el.check('agreement:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody Agreement resources) {
        return new ResponseEntity<>(agreementService.create(resources), HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改api/agreement")
    @ApiOperation("修改api/agreement")
    @PreAuthorize("@el.check('agreement:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody Agreement resources) {
        agreementService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除api/agreement")
    @ApiOperation("删除api/agreement")
    @PreAuthorize("@el.check('agreement:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        agreementService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}