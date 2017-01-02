package com.softtek.jpa.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.CartDetails;
import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.domain.CartKey;
import com.softtek.jpa.domain.ShipToEntity;
import com.softtek.jpa.domain.StatusEntity;
import com.softtek.jpa.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<CartEntity> findAllCarts() {
		return cartRepository.findAllByOrderByCartDetailsShipToAscAuditCreateDateAsc();
	}

	@Override
	public CartEntity create(CartEntity cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity findByCartKey(Long cartId) {
		CartKey cartKey = new CartKey();
		cartKey.setCartId(cartId);
		return cartRepository.findByCartKey(cartKey);
	}

	@Override
	public boolean update(CartEntity cart) {
		if (this.isValidCart(cart)) {
			if (cartRepository.exists(cart.getCartKey())) {
				CartEntity updatedCart = cartRepository.findByCartKey(cart.getCartKey());
				updatedCart.setCartDetails(
						new CartDetails(
								cart.getCartDetails().getLinesAmount(), cart.getCartDetails().getShippingAmount(), cart.getCartDetails().getCartAmount(),
								new ShipToEntity(cart.getCartDetails().getShipTo().getId()),
								new StatusEntity(cart.getCartDetails().getStatus().getId())
								)
						);
				logger.info("UPDATE CART METHOD: ", updatedCart.getCartKey().getCartId());
				cartRepository.save(updatedCart);
				return true;
			}
		}
		return false;
	}

	@Override
	public CartEntity delete(Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isValidCart(CartEntity cart){
		if (cart.getCartDetails().getLinesAmount() == null
				|| cart.getCartDetails().getLinesAmount() == 0
				|| cart.getCartDetails().getShippingAmount() == null
				|| cart.getCartDetails().getShippingAmount() == 0
				|| cart.getCartDetails().getShipTo() == null
				|| cart.getCartDetails().getShipTo().getId() == null
				|| cart.getCartDetails().getShipTo().getId() == 0
				|| cart.getCartDetails().getStatus() == null
				|| cart.getCartDetails().getStatus().getId() == null
				|| cart.getCartDetails().getStatus().getId() == 0) {
			return false;
		}
		
		return true;
		
	}

}
