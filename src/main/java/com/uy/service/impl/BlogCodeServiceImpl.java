package com.uy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uy.mapper.BlogCodeMapper;
import com.uy.pojo.BlogCode;
import com.uy.service.BlogCodeService;
import org.springframework.stereotype.Service;

/**
* @author my
* @description 针对表【blog_code】的数据库操作Service实现
* @createDate 2023-01-21 12:43:28
*/
@Service
public class BlogCodeServiceImpl extends ServiceImpl<BlogCodeMapper, BlogCode>
    implements BlogCodeService {

}




