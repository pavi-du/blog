package com.pavi.blog.mapper;

import com.pavi.blog.po.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMapper {

    void saveType(Type type);

    void removeTypeById(Long id);

    void updateTypeById(Type type);

    Type getTypeById(Long id);

    List<Type> listTypeWithBlog();


    List<Type> listType();
}
