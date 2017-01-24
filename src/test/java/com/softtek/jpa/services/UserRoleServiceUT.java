package com.softtek.jpa.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserRoleServiceUT {
	
	@Mock
	private UserRoleService userRoleService;
	
	@Test
	public void findAllUserRoleTest(){
		Assert.assertNotNull(userRoleService.findAllUserRole());
	}
}
