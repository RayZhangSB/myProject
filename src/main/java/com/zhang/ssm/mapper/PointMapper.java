package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.Point;
import com.zhang.ssm.pojo.PointExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointMapper {
    int countByExample(PointExample example);

    int deleteByExample(PointExample example);

    int deleteByPrimaryKey(Integer pointId);

    int insert(Point record);

    int insertSelective(Point record);

    List<Point> selectByExample(PointExample example);

    Point selectByPrimaryKey(Integer pointId);

    int updateByExampleSelective(@Param("record") Point record, @Param("example") PointExample example);

    int updateByExample(@Param("record") Point record, @Param("example") PointExample example);

    int updateByPrimaryKeySelective(Point record);

    int updateByPrimaryKey(Point record);
}