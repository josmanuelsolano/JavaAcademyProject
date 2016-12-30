package com.softtek.jpa.domain;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class CartEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CartKey cartKey;
	
	@Embedded
	private CartDetails cartDetails;
	
	@Embedded
	private Audit audit;

	public CartKey getCartKey() {
		return cartKey;
	}

	public void setCartKey(CartKey cartKey) {
		this.cartKey = cartKey;
	}

	public CartDetails getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(CartDetails cartDetails) {
		this.cartDetails = cartDetails;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
	

}
