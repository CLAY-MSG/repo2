package com.xgk.service.impl;

import com.xgk.domain.Bill;
import com.xgk.service.BillService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 15:20
 */
@Service("billService")
public class BillServiceImpl implements BillService {
    @Override
    public List<Bill> findAll() {
        return null;
    }
}
