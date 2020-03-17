package com.xgk.dao;

import com.xgk.domain.Bill;
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
public class BillDaoTest {

    @Autowired
    private BillDao billDao;

    @Test
    public void testFindAll(){
        Bill bill = new Bill();
        List<Bill> all = billDao.findAll();
        System.out.println(all);
    }
    @Test
    public void testFindAllByCondition(){
        Bill bill = new Bill();
        bill.setProductName("洗发水");
        bill.setProName("无锡喜源坤商行");
        bill.setIsPayment(1);
        List<Bill> all = billDao.findAllByCondition(bill);
        System.out.println(all);
    }
}
