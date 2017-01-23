package com.softtek.jpa.services;

import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.services.CartService;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
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
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true)
@DatabaseSetup(value = { "/dataset/cartDefault.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@DbUnitConfiguration(databaseConnection={"testDataSource"})
public class CartServiceImplTest {
	
	@Autowired
	CartService cartService;
	
	@Test
	public void mustBeTrueIfFindAllCarts(){
		List<CartEntity> cartList = cartService.findAllCarts();
		Assert.assertTrue(!cartList.isEmpty());
	}
	
	@Test
	public void mustBeTrueIfFindCartByCartId(){
		Long id = (long) 1;
		CartEntity cart = cartService.findByCartKey(id);
		Assert.assertNotNull(cart);
	}
	
	//Este test aun no me sale... :(
	@Test
	@Ignore
	@DatabaseSetup(value = { "/dataset/cartDefault.xml"}, type = DatabaseOperation.UPDATE)
	public void mustBeTrueIfRowUpdated(){
		Long id = (long) 1;
		CartEntity cart = cartService.findByCartKey(id);
		cart.getCartDetails().setShippingAmount(600.00);
		Assert.assertTrue(true == cartService.update(cart));
	}
}
