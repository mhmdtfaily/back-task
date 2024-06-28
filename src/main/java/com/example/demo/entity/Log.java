package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime updateTime = LocalDateTime.now();
    private int oldQuantity;
    private int newQuantity;
    private BigDecimal oldPrice;
    private BigDecimal newPrice;

    @ManyToOne
    @JoinColumn(name = "sale_transaction_id")
    private SalesTransaction salesTransaction;

    public Log() {}

	public Log(LocalDateTime updateTime, int oldQuantity, int newQuantity, BigDecimal oldPrice, BigDecimal newPrice,
			SalesTransaction salesTransaction, Seller updatedBy) {
		super();
		this.updateTime = updateTime;
		this.oldQuantity = oldQuantity;
		this.newQuantity = newQuantity;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.salesTransaction = salesTransaction;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public int getOldQuantity() {
		return oldQuantity;
	}

	public void setOldQuantity(int oldQuantity) {
		this.oldQuantity = oldQuantity;
	}

	public int getNewQuantity() {
		return newQuantity;
	}

	public void setNewQuantity(int newQuantity) {
		this.newQuantity = newQuantity;
	}

	public BigDecimal getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}

	public BigDecimal getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}

	public SalesTransaction getSalesTransaction() {
		return salesTransaction;
	}

	public void setSalesTransaction(SalesTransaction salesTransaction) {
		this.salesTransaction = salesTransaction;
	}

}
