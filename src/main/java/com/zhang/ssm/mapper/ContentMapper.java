package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.Content;
import com.zhang.ssm.pojo.ContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {
    int countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExampleWithBLOBs(ContentExample example);

    List<Content> selectByExample(ContentExample example);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);
}