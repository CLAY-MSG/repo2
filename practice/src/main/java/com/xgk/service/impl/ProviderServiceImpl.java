package com.xgk.service.impl;

import com.xgk.dao.ProviderDao;
import com.xgk.domain.Provider;
import com.xgk.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:35
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDao providerDao;
    @Override
    public List<Provider> findAll() {
        return null;
    }
}
