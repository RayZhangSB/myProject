package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.AuthOpreator;
import com.zhang.ssm.pojo.AuthOpreatorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthOpreatorMapper {
    int countByExample(AuthOpreatorExample example);

    int deleteByExample(AuthOpreatorExample example);

    int deleteByPrimaryKey(String authScope);

    int insert(AuthOpreator record);

    int insertSelective(AuthOpreator record);

    List<AuthOpreator> selectByExample(AuthOpreatorExample example);

    AuthOpreator selectByPrimaryKey(String authScope);

    int updateByExampleSelective(@Param("record") AuthOpreator record, @Param("example") AuthOpreatorExample example);

    int updateByExample(@Param("record") AuthOpreator record, @Param("example") AuthOpreatorExample example);

    int updateByPrimaryKeySelective(AuthOpreator record);

    int updateByPrimaryKey(AuthOpreator record);
}