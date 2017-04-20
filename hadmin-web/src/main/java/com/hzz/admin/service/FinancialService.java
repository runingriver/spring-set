package com.hzz.admin.service;

import java.util.Map;

public interface FinancialService {
    int batchInsertToFinancial(Map<String, Integer> mobiles,String column);
}
