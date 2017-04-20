package com.hzz.admin.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FinancialDao {

    Integer insertIntoFinancial(@Param("mobile") Map<String,Integer> mobile, @Param("col") String col);
}
