package com.mayi.user.mapper;


import com.mayi.user.entity.UserAddress;
import com.mayi.user.entity.UserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDo record);

    int insertSelective(UserDo record);

    UserDo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDo record);

    int updateByPrimaryKey(UserDo record);

    int selectCount();

    void insertUserAddress(@Param("list") List<UserAddress> userDo);
}