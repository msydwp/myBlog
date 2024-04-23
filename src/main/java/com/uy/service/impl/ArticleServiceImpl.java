package com.uy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uy.mapper.ArticleMapper;
import com.uy.pojo.Article;
import com.uy.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
* @author my
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-11-29 10:41:39
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

}




