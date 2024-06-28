package com.example.demo.dto;

import java.math.BigDecimal;

public class UpdateSaleRequest {
	  private int new_quantity;
	    private BigDecimal new_price;
	    
		public UpdateSaleRequest() {}
		
		public UpdateSaleRequest(int new_quantity, BigDecimal new_price) {
			super();
			this.new_quantity = new_quantity;
			this.new_price = new_price;
		}
		public int getNew_quantity() {
			return new_quantity;
		}
		public void setNew_quantity(int new_quantity) {
			this.new_quantity = new_quantity;
		}
		public BigDecimal getNew_price() {
			return new_price;
		}
		public void setNew_price(BigDecimal new_price) {
			this.new_price = new_price;
		}
}
