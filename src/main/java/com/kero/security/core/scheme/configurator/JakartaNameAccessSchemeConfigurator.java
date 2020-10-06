package com.kero.security.core.scheme.configurator;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kero.security.core.scheme.AccessScheme;

public class JakartaNameAccessSchemeConfigurator implements AccessSchemeConfigurator {

	private static Logger LOGGER = LoggerFactory.getLogger("Kero-Security-Jakarta");
	
	@Override
	public void configure(AccessScheme scheme) {
	
		Class<?> type = scheme.getTypeClass();
	
		while(type != Object.class && !type.isAnnotationPresent(Entity.class)) {
	
			type = type.getSuperclass();
		}
		
		if(!type.isAnnotationPresent(Entity.class)) return;

		Entity annotation = type.getAnnotation(Entity.class);
		
		String name = annotation.name();
		
		scheme.setAliase(name);
		
		LOGGER.info("Fetch scheme aliase: "+name+" from @Entity");
	}
}
