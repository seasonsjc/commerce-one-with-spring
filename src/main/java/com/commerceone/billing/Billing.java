package com.commerceone.billing;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.commerceone.shared.domain.RootAggregate;

@Entity
public class Billing extends RootAggregate {
	
	@Enumerated(EnumType.STRING)
	private BillingType type;
		
	public Billing() {
	}

	public BillingType getType() {
		return type;
	}

	public void setType(BillingType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Billing [type=");
		builder.append(type);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getCreatedDate()=");
		builder.append(getCreatedDate());
		builder.append(", getLastModifiedDate()=");
		builder.append(getLastModifiedDate());
		builder.append("]");
		return builder.toString();
	}

	
	
}
