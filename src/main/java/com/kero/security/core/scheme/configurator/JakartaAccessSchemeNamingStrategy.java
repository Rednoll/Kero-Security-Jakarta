package com.kero.security.core.scheme.configurator;

import javax.persistence.Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kero.security.core.scheme.strategy.DefaultAccessSchemeNamingStrategy;

public class JakartaAccessSchemeNamingStrategy extends DefaultAccessSchemeNamingStrategy {

	private static Logger LOGGER = LoggerFactory.getLogger("Kero-Security-Jakarta");
	
	@Override
	public String getName(Class<?> rawType) {

		if(!rawType.isAnnotationPresent(Entity.class)) return super.getName(rawType);

		Entity annotation = rawType.getAnnotation(Entity.class);
		
		String name = annotation.name();
		
		LOGGER.debug("Fetch scheme aliase: \""+name+"\" from @Entity");
	
		return name;
	}
}
