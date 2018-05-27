package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.AbnormalInfo;
import com.zhang.ssm.pojo.AbnormalInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AbnormalInfoMapper {
    int countByExample(AbnormalInfoExample example);

    int deleteByExample(AbnormalInfoExample example);

    int deleteByPrimaryKey(Integer abnormalInfoid);

    int insert(AbnormalInfo record);

    int insertSelective(AbnormalInfo record);

    List<AbnormalInfo> selectByExample(AbnormalInfoExample example);

    AbnormalInfo selectByPrimaryKey(Integer abnormalInfoid);

    int updateByExampleSelective(@Param("record") AbnormalInfo record, @Param("example") AbnormalInfoExample example);

    int updateByExample(@Param("record") AbnormalInfo record, @Param("example") AbnormalInfoExample example);

    int updateByPrimaryKeySelective(AbnormalInfo record);

    int updateByPrimaryKey(AbnormalInfo record);
}