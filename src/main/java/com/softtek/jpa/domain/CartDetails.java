package com.softtek.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CartDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="lines_amount", nullable = true)
	private Double linesAmount;
	
	@Column(name="shipping_amount", nullable = true)
	private Double shippingAmount;
	
	@Column(name="cart_amount", nullable = true)
	private Double cartAmount;
	
	@ManyToOne
	@JoinColumn(name = "ship_to_id", nullable = true)
	private ShipTo shipTo;
	
	@ManyToOne
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;


    public Double getLinesAmount() {
        return this.linesAmount;
    }

    public void setLinesAmount(Double linesAmount) {
        this.linesAmount = linesAmount;
    }

    public Double getShippingAmount() {
        return this.shippingAmount;
    }

    public void setShippingAmount(Double shipToAmount) {
        this.shippingAmount = shipToAmount;
    }

    public Double getCartAmount() {
        return this.cartAmount;
    }

    public void setCartAmount(Double cartAmount) {
        this.cartAmount = cartAmount;
    }

    public ShipTo getShipTo() {
        return this.shipTo;
    }

    public void setShipTo(ShipTo shipTo) {
        this.shipTo = shipTo;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
