package com.hzz.admin.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hzz.admin.dao.FinancialDao;
import com.hzz.admin.service.FinancialService;

@Service
public class FinancialServiceImpl implements FinancialService {

    @Resource
    FinancialDao financialDao;

    public int batchInsertToFinancial(Map<String, Integer> mobiles, String column) {
        if (mobiles == null || mobiles.isEmpty() || StringUtils.isEmpty(column)) {
            return 0;
        }
        Integer integer = 0;
        try {
             integer = financialDao.insertIntoFinancial(mobiles, column);
        } catch (Exception e) {
            //no...
        }
        return integer;
    }
}
