package com.softtek.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Embeddable
public class CartKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cart_id", nullable = false)
	private Long cart_id;

	public Long getCartId() {
		return cart_id;
	}

	public void setCartId(Long cart_id) {
		this.cart_id = cart_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart_id == null) ? 0 : cart_id.hashCode());
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
		CartKey other = (CartKey) obj;
		if (cart_id == null) {
			if (other.cart_id != null)
				return false;
		} else if (!cart_id.equals(other.cart_id))
			return false;
		return true;
	}

}
