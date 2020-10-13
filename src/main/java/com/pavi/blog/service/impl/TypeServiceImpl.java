package com.pavi.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pavi.blog.mapper.TypeMapper;
import com.pavi.blog.po.Type;
import com.pavi.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/7 14:49
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> listType(int pageNum) {

        PageHelper.offsetPage(pageNum,8);
        List<Type> typeList = typeMapper.listType();
        PageInfo<Type> typePageInfo = new PageInfo<>(typeList);
        return typePageInfo;
    }


    @Override
    public void removeTypeById(Long id) {

        typeMapper.removeTypeById(id);
    }

    @Override
    public void saveType(Type type) {
        typeMapper.saveType(type);
    }

    @Override
    public Type getTypeById(Long id) {

        Type type = typeMapper.getTypeById(id);
        return type;
    }

    @Override
    public void updateType(Type type) {
        typeMapper.updateTypeById(type);
    }

    @Override
    public List<Type> listType() {

        List<Type> types = typeMapper.listTypeWithBlog();
        return types;
    }

    @Override
    public List<Type> listTypeTop(int count) {

        PageHelper.startPage(1,count);
        List<Type> types = typeMapper.listTypeWithBlog();
        PageInfo<Type> typePageInfo = new PageInfo<>(types);
        return typePageInfo.getList();
    }

    @Override
    public PageInfo<Type> listTypeByPaging(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Type> types = typeMapper.listType();
        PageInfo<Type> typePageInfo = new PageInfo<>(types);
        return typePageInfo;
    }


}
