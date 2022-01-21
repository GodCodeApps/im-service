package com.imovie.modules.movie.service;

import com.imovie.modules.movie.domain.Movie;
import com.imovie.modules.movie.service.dto.*;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MovieService {

    /*查询全部电影*/
    Map<String, Object> queryAll(MovieQueryCriteria criteria, Pageable pageable);

    /*查询全部电影不分页，导出用*/
    List<MovieDto> queryAll(MovieQueryCriteria criteria);

    /*查询最新电影*/
    Map<String, Object> queryLatest(MovieLatestQueryCriteria criteria, Pageable pageable);

    /*查询最热电影*/
    Map<String, Object> queryHot(MovieHotQueryCriteria criteria, Pageable pageable);

    /*查询最经典电影*/
    Map<String, Object> queryBest(MovieBestQueryCriteria criteria, Pageable pageable);

    /*根据电影名称、id查询*/
    Map<String, Object> search(MovieQueryCriteria criteria, Pageable pageable);

    /*根据id查找*/
    Movie findById(Long id);

    /*新增电影*/
    void add(Movie movie);

    /*编辑电影信息*/
    void edit(Movie movie);

    /*删除*/
    void delete(long id);

    void download(List<MovieDto> queryAll, HttpServletResponse response) throws IOException;
}
