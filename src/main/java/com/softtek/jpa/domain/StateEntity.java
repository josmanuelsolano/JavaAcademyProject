package com.softtek.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="state")
public class StateEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="state_id", nullable = false)
	private Long stateId;
	
	@Column(name="description", nullable = true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="shipping_zone_id")
	private ShippingZoneEntity shippingZoneId;

	public StateEntity() {
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ShippingZoneEntity getShippingZoneId() {
		return shippingZoneId;
	}

	public void setShippingZoneId(ShippingZoneEntity shippingZoneId) {
		this.shippingZoneId = shippingZoneId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((shippingZoneId == null) ? 0 : shippingZoneId.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
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
		StateEntity other = (StateEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (shippingZoneId == null) {
			if (other.shippingZoneId != null)
				return false;
		} else if (!shippingZoneId.equals(other.shippingZoneId))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}
	
	

}
