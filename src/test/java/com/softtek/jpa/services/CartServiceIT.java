package com.softtek.jpa.services;

import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.services.CartService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value = { "/dataset/cartDefault.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection={"testDataSource"})
public class CartServiceIT {
	
	@Autowired
	CartService cartService;
	
	@Test
	public void mustBeTrueIfFindAllCarts(){
		Assert.assertNotNull(cartService.findAllCarts());
	}
	
	@Test
	public void mustBeNotNullIfFindCartByCartId(){
		Assert.assertNotNull(cartService.findByCartKey(1L));
	}
	
	@Test
	@ExpectedDatabase(value = "/dataset/cartExpected.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
	public void mustBeTrueIfRowUpdated() throws Exception{
		CartEntity cart = cartService.findByCartKey(1L);
		cart.getCartDetails().setShippingAmount(600.00);
		cartService.update(cart);
	}
}
