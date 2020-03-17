package com.xgk.dao;

import com.xgk.domain.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ProviderDaoTest {

    @Autowired
    private ProviderDao providerDao;
    @Test
    public void testFindTotalCount(){
        System.out.println(providerDao.findTotalCount());
    }
    @Test
    public void testFindAll(){
        List<Provider> all = providerDao.findAll();
        System.out.println(all);
    }
    @Test
    public void testAddProvider(){
        Provider provider = new Provider();
        provider.setProName("啦啦啦");
        System.out.println(providerDao.addProvider(provider));
    }

    @Test
    public void testUpdateProvider(){
        Provider provider = new Provider();
        provider.setId(18l);
        provider.setProName("啦啦啦");
        System.out.println(providerDao.updateProvider(provider));
    }
}
