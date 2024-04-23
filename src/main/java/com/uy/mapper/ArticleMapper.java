package com.uy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uy.pojo.Article;
import org.springframework.stereotype.Repository;

/**
* @author my
* @description 针对表【article】的数据库操作Mapper
* @createDate 2022-11-29 10:41:39
* @Entity generator.domain.Article
*/
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}




