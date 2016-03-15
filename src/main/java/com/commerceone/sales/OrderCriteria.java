package com.commerceone.sales;

import java.io.Serializable;
import java.util.Date;



public class OrderCriteria implements Serializable {

	private Date startDate;
	
	private Date endDate;
	
	private Long orderNumber;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderCriteria [startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", orderNumber=");
		builder.append(orderNumber);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}

