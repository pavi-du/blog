package com.pavi.blog.service.impl;

import com.pavi.blog.mapper.BlogMapper;
import com.pavi.blog.po.Blog;
import com.pavi.blog.service.ArichivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author pavi
 * @date 2020-10-12 20:28
 **/

@Service
public class ArichivesServiceImpl implements ArichivesService {


    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Map<Integer,List<Blog>> listBlogByArichives() {

        List<Integer> yearList = blogMapper.listBlogOfYear();
        Map<Integer,List<Blog>> blogMap = new TreeMap<>((o1,o2)->{
            return o2 -o1;
        });
        for (Integer year : yearList) {
            List<Blog> tempBlogList = blogMapper.listBlogByYear(year);
            blogMap.put(year,tempBlogList);
        }
        return blogMap;
    }
}
