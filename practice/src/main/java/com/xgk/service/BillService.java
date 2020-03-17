package com.xgk.service;

import com.xgk.domain.Bill;
import com.xgk.domain.Provider;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:34
 */
public interface BillService {

    List<Bill> findAll();
}
