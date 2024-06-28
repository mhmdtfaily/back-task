package com.example.demo.seed;

import com.example.demo.entity.Category;
import com.example.demo.entity.Seller;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        seedSellers();
        seedCategories();
    }

    private void seedSellers() {
        List<Seller> existingSellers = sellerRepository.findAll();
        if (existingSellers.isEmpty()) {
            Seller seller1 = new Seller("seller1", "seller1", "123456");
            Seller seller2 = new Seller("seller2", "seller2", "123456");

            sellerRepository.saveAll(Arrays.asList(seller1, seller2));
        }
    }

    private void seedCategories() {
        List<Category> existingCategories = categoryRepository.findAll();
        if (existingCategories.isEmpty()) {
            Category category1 = new Category("Electronics");
            Category category2 = new Category("Accessories");
            Category category3 = new Category("Outdoor");

            categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        }
    }
}
