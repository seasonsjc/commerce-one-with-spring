package com.commerceone.identity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Login implements Serializable {

	private String username;
	private String passoword;

	public Login() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassoword() {
		return passoword;
	}

	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passoword == null) ? 0 : passoword.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Login other = (Login) obj;
		if (passoword == null) {
			if (other.passoword != null)
				return false;
		} else if (!passoword.equals(other.passoword))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Login [username=").append(username).append(", passoword=").append(passoword).append("]");
		return builder.toString();
	}

}
