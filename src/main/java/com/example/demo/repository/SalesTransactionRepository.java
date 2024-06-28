package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SalesTransaction;

public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, Long> {
}