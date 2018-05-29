package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.AuthGroup;
import com.zhang.ssm.pojo.AuthGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthGroupMapper {
    int countByExample(AuthGroupExample example);

    int deleteByExample(AuthGroupExample example);

    int deleteByPrimaryKey(String authGroup);

    int insert(AuthGroup record);

    int insertSelective(AuthGroup record);

    List<AuthGroup> selectByExample(AuthGroupExample example);

    AuthGroup selectByPrimaryKey(String authGroup);

    int updateByExampleSelective(@Param("record") AuthGroup record, @Param("example") AuthGroupExample example);

    int updateByExample(@Param("record") AuthGroup record, @Param("example") AuthGroupExample example);

    int updateByPrimaryKeySelective(AuthGroup record);

    int updateByPrimaryKey(AuthGroup record);
}