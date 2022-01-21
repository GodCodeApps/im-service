package com.imovie.modules.movie.rest;

import com.imovie.annotation.AnonymousAccess;
import com.imovie.aop.log.Log;
import com.imovie.modules.movie.domain.Movie;
import com.imovie.modules.movie.service.MovieService;
import com.imovie.modules.movie.service.dto.MovieBestQueryCriteria;
import com.imovie.modules.movie.service.dto.MovieHotQueryCriteria;
import com.imovie.modules.movie.service.dto.MovieLatestQueryCriteria;
import com.imovie.modules.movie.service.dto.MovieQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Api(tags = "影视：电影管理")
@RestController
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @AnonymousAccess
    @Log("查询最新电影")
    @ApiOperation("最新电影")
    @GetMapping(value = "/latest")
    public ResponseEntity<Object> getLatestList(MovieLatestQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("createTime"), Sort.Order.desc("updateTime")));
        return new ResponseEntity<>(movieService.queryLatest(criteria, page), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询最热门电影")
    @ApiOperation("热门电影")
    @GetMapping(value = "/hot")
    public ResponseEntity<Object> getHotList(MovieHotQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("createTime"), Sort.Order.desc("updateTime")));
        return new ResponseEntity<>(movieService.queryHot(criteria, page), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询经典电影")
    @ApiOperation("经典电影")
    @GetMapping(value = "/best")
    public ResponseEntity<Object> getBestList(MovieBestQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("ranking")));
        return new ResponseEntity<>(movieService.queryBest(criteria, page), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询全部电影")
    @ApiOperation("全部电影")
    @GetMapping(value = "/all")
    public ResponseEntity<Object> getAllList(MovieQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Order.asc("id")));
        return new ResponseEntity<>(movieService.queryAll(criteria, page), HttpStatus.OK);
    }

    @AnonymousAccess
    @Log("查询电影")
    @ApiOperation("根据id、名称查询电影")
    @GetMapping(value = "/search")
    public ResponseEntity<Object> searchList(MovieQueryCriteria criteria, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC));
        return new ResponseEntity<>(movieService.search(criteria, page), HttpStatus.OK);
    }

    @Log("添加电影")
    @ApiOperation("新增电影")
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Movie resource) {
        movieService.add(resource);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Log("编辑电影")
    @ApiOperation("编辑电影状态")
    @PutMapping
    @PreAuthorize("@el.check('movie:edit')")
    public ResponseEntity<Object> editMovie(@Validated(Movie.Update.class) @RequestBody Movie resources) {
        movieService.edit(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("编辑电影：删除")
    @ApiOperation("删除电影")
    @DeleteMapping(value = "/{type}")
    @PreAuthorize("@el.check('movie:delete')")
    public ResponseEntity<Object> delete(@PathVariable String type, @RequestBody Set<Long> ids) {
        for (Long id : ids) {
            //最新、热门、经典电影
            if ("latest".equals(type) || "hot".equals(type) || "best".equals(type)) {
                Movie movie = movieService.findById(id);
                //取消最新
                if ("latest".equals(type))
                    movie.setLatest(false);

                    // 取消热门
                else if ("hot".equals(type))
                    movie.setHot(false);

                    //删除排名信息
                else
                    movie.setRanking(0);
                movieService.edit(movie);
            }

            //删除
            else {
                movieService.delete(id);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("导出电影数据")
    @ApiOperation("导出电影数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('movie:list')")
    public void download(HttpServletResponse response, MovieQueryCriteria criteria) throws IOException {
        movieService.download(movieService.queryAll(criteria), response);
    }
}
