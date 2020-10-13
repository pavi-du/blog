package com.pavi.blog.mapper;

import com.pavi.blog.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserMapper {


    User findUserByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
}
