package com.imovie.modules.movie.service.impl;

import com.imovie.modules.movie.domain.Movie;
import com.imovie.modules.movie.repository.MovieRepository;
import com.imovie.modules.movie.service.MovieService;
import com.imovie.modules.movie.service.dto.*;
import com.imovie.modules.movie.service.mapper.MovieMapper;
import com.imovie.utils.FileUtil;
import com.imovie.utils.PageUtil;
import com.imovie.utils.QueryHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "movie")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public Map<String, Object> queryAll(MovieQueryCriteria criteria, Pageable pageable) {
        Page<Movie> page = movieRepository.findAll((root, query, cb) -> QueryHelp.getPredicate(root, criteria, cb), pageable);
        return PageUtil.toPage(page.map(movieMapper::toDto));
    }

    @Override
    public List<MovieDto> queryAll(MovieQueryCriteria criteria) {
        List<Movie> users = movieRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder));
        return movieMapper.toDto(users);
    }

    @Override
    public Map<String, Object> queryLatest(MovieLatestQueryCriteria criteria, Pageable pageable) {
        Page<Movie> page = movieRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(movieMapper::toDto));
    }

    @Override
    public Map<String, Object> queryHot(MovieHotQueryCriteria criteria, Pageable pageable) {
        Page<Movie> page = movieRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(movieMapper::toDto));
    }

    @Override
    public Map<String, Object> queryBest(MovieBestQueryCriteria criteria, Pageable pageable) {
        Page<Movie> page = movieRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(movieMapper::toDto));
    }

    @Override
    public Map<String, Object> search(MovieQueryCriteria criteria, Pageable pageable) {
        Page<Movie> page = movieRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(movieMapper::toDto));
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseGet(Movie::new);
    }

    @Override
    public void add(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void edit(Movie resources) {
        movieRepository.save(resources);
    }

    @Override
    public void delete(long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void download(List<MovieDto> queryAll, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (MovieDto dto : queryAll) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("电影名称", dto.getTitle());
            map.put("海报", dto.getCover());
            map.put("类型", dto.getType());
            map.put("豆瓣评分", dto.getRating());
            map.put("主演", dto.getActors());
            map.put("导演", dto.getDirector());
            map.put("编剧", dto.getWriter());
            map.put("上映年份", dto.getReleaseDate());
            map.put("时长", dto.getDuration());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}
