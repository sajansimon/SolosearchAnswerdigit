package com.solo.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
	
	public static final Logger Log=LogManager.getLogger();
	public static void startTestCase(String testcasename) {
		Log.info("*************************************************************************************");
		Log.info("**              Start Test   Execution"+testcasename+"                 ***");
		Log.info("***************************"); 
	}


		public static void info(String msg) {
			Log.info(msg);
			
			
		}




}
