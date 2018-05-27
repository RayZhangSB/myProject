package com.zhang.ssm.mapper;

import com.zhang.ssm.pojo.Token;
import com.zhang.ssm.pojo.TokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TokenMapper {
    int countByExample(TokenExample example);

    int deleteByExample(TokenExample example);

    int deleteByPrimaryKey(Integer tokenId);

    int insert(Token record);

    int insertSelective(Token record);

    List<Token> selectByExample(TokenExample example);

    Token selectByPrimaryKey(Integer tokenId);

    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

    int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
}