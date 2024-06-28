package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.SaleRequest;
import com.example.demo.dto.UpdateSaleRequest;
import com.example.demo.entity.Sale;
import com.example.demo.entity.SalesTransaction;
import com.example.demo.repository.SaleRepository;
import com.example.demo.repository.SalesTransactionRepository;
import com.example.demo.service.SaleService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;
    
    @Autowired
    private SalesTransactionRepository salesTransactionRepository;
    
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
    
    @PostMapping
    public Sale createSale(@RequestBody SaleRequest saleRequest) {
        return saleService.createSale(saleRequest);
    }
   
    @PutMapping("/{transaction_id}")
    public void updateSale(@PathVariable Long transaction_id, @RequestBody UpdateSaleRequest updateSaleRequest) {
    	 saleService.updateSale(transaction_id,updateSaleRequest);
//        sale.setTotal(saleDetails.getTotal());
    }
}
