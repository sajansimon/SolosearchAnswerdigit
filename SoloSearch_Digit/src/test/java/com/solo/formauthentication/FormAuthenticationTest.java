/**
 * @author sajan
 * FormAuthentication
 * 
 */


package com.solo.formauthentication;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.solo.utility.Log;
import com.solo.BaseTest.BaseTest;
import com.solo.constatns.SoloProjectConstants;
import com.solo.utility.Log;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;

public class FormAuthenticationTest extends BaseTest {
	
	
	
		
		@Test()
		/**
		 * 
		 * correctUserandincorrectPass
		 * 
		 */
	
		public void form_auth_correctUserandincorrectPass() throws InterruptedException {
			
			// TODO Auto-generated method stub
			navigationTo_BasicAuth();
			
			try {
				driver.get("http://admin:xxxx@the-internet.herokuapp.com/basic_auth");
				Assert.assertEquals(SoloProjectConstants.basic_auth_successfulMsg, driver.findElement(By.xpath(projectproperties.getProperty("BasicAuthSuccessfulMsg"))).getText());
				System.out.println("AssertLogin:--Basic authentiction is failed");
				Assert.fail("Basic authentiction is failed");
			     
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Thread.sleep(1000);
				Assert.fail("Basic authentiction is failed for correctUserandincorrectPass");
				Log.info(e.getMessage());
				
				
			}
			
		 }

		 @Test()
	   /**
	    * 
	    * incorrectUserandcorrectPass
	    * 
	    */
	
		public void form_auth_incorrectUserandcorrectPass() throws InterruptedException {
			 
			// TODO Auto-generated method stub
			 navigationTo_BasicAuth();
			 
			try {
				driver.get("http://yyyy:admin@the-internet.herokuapp.com/basic_auth");
				Assert.assertEquals(SoloProjectConstants.basic_auth_successfulMsg, driver.findElement(By.xpath(projectproperties.getProperty("BasicAuthSuccessfulMsg"))).getText());
				Thread.sleep(500);
				System.out.println("AssertLogin:--Basic authentiction is failed");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Thread.sleep(1000);
				Assert.fail("Basic authentiction is failed for incorrectUserandcorrectPass");
				
			}
			
			
		}
		
		
		@Test()
		/**
		 * 
		 * 
		 * validUserIDandPasscode()
		 * 
		 * 
		 */
		public void form_auth_validUserIDandPasscode() {
			
			// TODO Auto-generated method stub
			navigationTo_BasicAuth();
			
			try {
				driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
				Assert.assertEquals(SoloProjectConstants.basic_auth_successfulMsg, driver.findElement(By.xpath(projectproperties.getProperty("BasicAuthSuccessfulMsg"))).getText());
				System.out.println("AssertLogin:--Basic authentiction successful with valid credentials");
			    
			
			} catch (Exception e) {
				// TODO Auto-generated catch blo"ck
				Assert.fail("failed --------------------------");
				Log.info(e.getMessage());
				
			}
			
		}


	
	
}
