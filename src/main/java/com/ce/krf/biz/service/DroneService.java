package com.ce.krf.biz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.DroneMapper;

@Component
public class DroneService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public DroneMapper droneMapper;
}
