package com.commerceone.event;

import javax.persistence.Entity;

import com.commerceone.shared.domain.RootAggregate;

@Entity
public class Queue extends RootAggregate {

	private String name;

	public Queue() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Queue [name=");
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
