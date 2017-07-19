package com.yyq.base.api.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public interface BaseMapper<T, Q, P> {

    long countByExample(Q example);

    int deleteByExample(Q example);

    int deleteByPrimaryKey(P key);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExample(Q example);

    T selectByPrimaryKey(P key);

    int updateByExampleSelective(@Param("record") T record, @Param("example") Q example);

    int updateByExample(@Param("record") T record, @Param("example") Q example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
