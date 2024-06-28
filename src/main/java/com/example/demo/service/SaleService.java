package com.example.demo.service;

import com.example.demo.dto.SaleRequest;
import com.example.demo.dto.UpdateSaleRequest;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;
    
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SellerRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Sale createSale(SaleRequest saleRequest) {
        // Fetch the client and seller entities
        Client client = clientRepository.findById(saleRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Seller seller = userRepository.findById(saleRequest.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        // Create the sale
        Sale sale = new Sale();
        sale.setClient(client);
        sale.setSeller(seller);
        sale.setTotal(saleRequest.getTotal());
        sale.setCreationDate(LocalDateTime.now());

        Sale savedSale = saleRepository.save(sale);

        // Create the transactions
        List<SalesTransaction> transactions = saleRequest.getTransactions().stream().map(txRequest -> {
            Product product = productRepository.findById(txRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            SalesTransaction transaction = new SalesTransaction();
            transaction.setQuantity(txRequest.getQuantity());
            transaction.setPrice(txRequest.getPrice());
            transaction.setSale(savedSale);
            transaction.setProduct(product);

            return transaction;
        }).collect(Collectors.toList());

        salesTransactionRepository.saveAll(transactions);

        return savedSale;
    }
    
    @Transactional
    public void updateSale(long transaction_id ,UpdateSaleRequest updateSaleRequest) {
    	SalesTransaction salesTransaction = salesTransactionRepository.findById(transaction_id).orElseThrow(() -> new RuntimeException("transaction id not found"));
    	
    	Log log=new Log();
    	
    	log.setSalesTransaction(salesTransaction);
    	log.setNewPrice(updateSaleRequest.getNew_price());
    	log.setOldPrice(salesTransaction.getPrice());
    	log.setNewQuantity(updateSaleRequest.getNew_quantity());
    	log.setOldQuantity(salesTransaction.getQuantity());
    	
    	logRepository.save(log);
    	
    	salesTransaction.setPrice(updateSaleRequest.getNew_price());
    	salesTransaction.setQuantity(updateSaleRequest.getNew_quantity());
    	
    	salesTransactionRepository.save(salesTransaction);
    	
    	
    	
    }
    
}
