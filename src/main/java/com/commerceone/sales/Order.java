package com.commerceone.sales;

import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import java.util.Locale;

import javax.persistence.TemporalType;

import com.commerceone.account.Customer;

import com.commerceone.account.Supplier;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Temporal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.GenerationType;
import javax.persistence.Embedded;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
@Table(name="ORDERS")
public class Order implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="SUPPLIER_ID"
			,foreignKey=@ForeignKey(name="FK_ORDER_SUPPLIERS"))
	private Supplier supplier;
	

	@ManyToOne()
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:SSZ",  timezone="America/Sao_Paulo")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@OneToMany(mappedBy="order"
			,cascade={CascadeType.MERGE, CascadeType.PERSIST}
			, fetch=FetchType.EAGER	)
	private List<OrderItem> items;
	
	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void add(OrderItem item) {
		
		if (items == null) items = new ArrayList<OrderItem>();
		
		item.setOrder(this);
		items.add(item);		
	}

	public void add(String  product) {
		OrderItem item = new OrderItem(product);
		add(item);
	}
		
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

		
	
}

