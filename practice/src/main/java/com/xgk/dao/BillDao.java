package com.xgk.dao;

import com.xgk.domain.Bill;
import com.xgk.domain.Provider;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:24
 */
@Repository
public interface BillDao {

    @Select("select count(*) from smbms_bill")
    int findTotalCount();

    @Select("SELECT b.id,b.`billCode`,b.productName,p.proName,b.`totalPrice`,b.`isPayment`,b.`creationDate`\n" +
            "FROM smbms_bill b,smbms_provider p\n" +
            "WHERE b.`providerId` = p.id")
    List<Bill> findAll();

    List<Bill> findAllBySomeCondition(Bill bill);

    List<Bill> findAllByCondition(Bill bill);

    List<Bill> findProviderAndBill(List<Integer> providerIdList);
}
