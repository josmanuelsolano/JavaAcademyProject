package com.softtek.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipping_zone")
public class ShippingZoneEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="shipping_zone_id", nullable = false)
	private String shippingZoneId;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="delivery_time", nullable = true)
	private Long deliveryTime;
	
	@Column(name="shipping_cost", nullable = false)
	private Double shippingCost;

	public ShippingZoneEntity() {
	}

	public String getShippingZoneId() {
		return shippingZoneId;
	}

	public void setShippingZoneId(String shippingZoneId) {
		this.shippingZoneId = shippingZoneId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(Double shippingCost) {
		this.shippingCost = shippingCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryTime == null) ? 0 : deliveryTime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((shippingCost == null) ? 0 : shippingCost.hashCode());
		result = prime * result + ((shippingZoneId == null) ? 0 : shippingZoneId.hashCode());
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
		ShippingZoneEntity other = (ShippingZoneEntity) obj;
		if (deliveryTime == null) {
			if (other.deliveryTime != null)
				return false;
		} else if (!deliveryTime.equals(other.deliveryTime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (shippingCost == null) {
			if (other.shippingCost != null)
				return false;
		} else if (!shippingCost.equals(other.shippingCost))
			return false;
		if (shippingZoneId == null) {
			if (other.shippingZoneId != null)
				return false;
		} else if (!shippingZoneId.equals(other.shippingZoneId))
			return false;
		return true;
	}
	
	
	

}
