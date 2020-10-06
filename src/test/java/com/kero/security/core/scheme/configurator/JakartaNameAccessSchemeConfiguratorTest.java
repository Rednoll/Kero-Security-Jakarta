package com.kero.security.core.scheme.configurator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kero.security.core.scheme.AccessScheme;
import com.kero.security.core.scheme.ClassAccessScheme;

public class JakartaNameAccessSchemeConfiguratorTest {

	@Test
	public void test() {
		
		JakartaNameAccessSchemeConfigurator conf = new JakartaNameAccessSchemeConfigurator();
		
		AccessScheme scheme = new ClassAccessScheme(null, JakartaNameTestEntity.class);
		
		conf.configure(scheme);
		
		assertEquals(scheme.getAliase(), "Jakarta");
	}
}
