package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.LineInfo;
import com.zhang.ssm.pojo.LineInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LineInfoMapper {
    int countByExample(LineInfoExample example);

    int deleteByExample(LineInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByName(String name);

    int insert(LineInfo record);

    int insertSelective(LineInfo record);

    List<LineInfo> selectByExample(LineInfoExample example);

    LineInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LineInfo record, @Param("example") LineInfoExample example);

    int updateByExample(@Param("record") LineInfo record, @Param("example") LineInfoExample example);

    int updateByPrimaryKeySelective(LineInfo record);

    int updateByPrimaryKey(LineInfo record);
}