package com.commerceone.event;

import javax.persistence.Entity;

import com.commerceone.shared.domain.RootAggregate;

@Entity
public class EventLog extends RootAggregate {

	private String name;

	private String status;
	
	public EventLog() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventLog [name=");
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
