package com.pavi.blog.service;

import com.pavi.blog.po.Blog;

import java.util.List;
import java.util.Map;

public interface ArichivesService {


    Map<Integer,List<Blog>> listBlogByArichives();
}
