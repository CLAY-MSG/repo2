package com.xgk.controller;

import com.xgk.domain.Bill;
import com.xgk.domain.Provider;
import com.xgk.service.BillService;
import com.xgk.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 15:16
 */
@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping("/findAllBill")
    public @ResponseBody List<Bill> findAllBill(){
        return billService.findAll();
    }


}
