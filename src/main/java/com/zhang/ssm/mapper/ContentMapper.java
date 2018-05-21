package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.Content;
import com.zhang.ssm.pojo.ContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {
    int countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Short noteId);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExampleWithBLOBs(ContentExample example);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Short noteId);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExampleWithBLOBs(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);
}