package com.pavi.blog.service;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Type;

import java.util.List;

public interface TypeService {
    PageInfo<Type> listType(int pageNum);

    void removeTypeById(Long id);

    void saveType(Type type);

    Type getTypeById(Long id);

    void updateType(Type type);


    /*
     * 列出所有类型
     *
     * @author pavi
     * @param
     * @return
     * @date 2020/10/12 1:29
     */
    List<Type> listType();


    List<Type> listTypeTop(int i);

    PageInfo<Type> listTypeByPaging(Integer pageNum, Integer pageSize);
}
