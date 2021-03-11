package com.example.project_.markerhub.mapper;

import com.example.project_.markerhub.entity.News;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2021-03-06
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {
//    @Select("select * from News")
    List<News> findALL();
}
