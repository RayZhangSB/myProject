package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.Catalog;
import com.zhang.ssm.pojo.CatalogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    int countByExample(CatalogExample example);

    int deleteByExample(CatalogExample example);

    int deleteByPrimaryKey(Byte id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    List<Catalog> selectByExample(CatalogExample example);

    Catalog selectByPrimaryKey(Byte id);

    int updateByExampleSelective(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByExample(@Param("record") Catalog record, @Param("example") CatalogExample example);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKey(Catalog record);
}