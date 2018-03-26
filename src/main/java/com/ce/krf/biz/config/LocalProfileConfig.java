package com.ce.krf.biz.config;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalProfileConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7814410438167535319L;

}
