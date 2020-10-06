package com.kero.security.core.scheme.configurator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JakartaNameAccessSchemeConfiguratorTest {

	@Test
	public void test() {
		
		EntityAccessSchemeNamingStrategy conf = new EntityAccessSchemeNamingStrategy();
		
		String name = conf.getName(JakartaNameTestEntity.class);
		
		assertEquals(name, "Jakarta");
	}
}
