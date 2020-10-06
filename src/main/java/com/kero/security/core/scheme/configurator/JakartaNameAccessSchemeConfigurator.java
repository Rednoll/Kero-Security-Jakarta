package com.kero.security.core.scheme.configurator;

import javax.persistence.Entity;

import com.kero.security.core.scheme.AccessScheme;

public class JakartaNameAccessSchemeConfigurator implements AccessSchemeConfigurator {

	@Override
	public void configure(AccessScheme scheme) {
	
		Class<?> type = scheme.getTypeClass();
	
		while(type != Object.class && !type.isAnnotationPresent(Entity.class)) {
	
			type = type.getSuperclass();
		}
		
		Entity annotation = type.getAnnotation(Entity.class);
		
		String name = annotation.name();
		
		scheme.setAliase(name);
	}
}
