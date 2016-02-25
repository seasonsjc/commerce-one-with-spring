package com.commerceone.notification;

import javax.persistence.Entity;

import com.commerceone.shared.domain.RootAggregate;

@Entity
public class MailBox extends RootAggregate {
	
	private String name;
	
	public MailBox() {
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MailBox [name=");
		builder.append(name);
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

