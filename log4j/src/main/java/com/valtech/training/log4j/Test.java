package com.valtech.training.log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
	private static final Logger log=LogManager.getLogger(Test.class);
	
	public static void processData() {
		log.trace("From Trace Method");
		log.debug("From Debug Method");
		log.info("From Info Method");
		log.warn("From Warn Method");
		log.error("From Error Method");
		log.fatal("From Fatal Method");
	}
	
	public static void main(String[] args) {
		processData();
	}
}
