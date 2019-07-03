package com.solo.key_presses;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import com.solo.BaseTest.BaseTest;
import com.solo.constatns.SoloProjectConstants;

import junit.framework.Assert;

public class KeyPress_OnMenu extends BaseTest {
	
	
	@Test
	public void clickon_keyPressLink() {
		
			navigateTo_App();
			try {
				driver.findElement(By.xpath(projectproperties.getProperty("keypresess"))).click();
	                
				/* verify the result page as expected*/
				
				Assert.assertEquals(SoloProjectConstants.expectedMsgKeypress, driver.findElement(By.xpath( projectproperties.getProperty("keypresess"))).getText());
	            
				validatetextentered();
			    } catch (Exception e) {
				// TODO Auto-generated catch block
			    	Assert.fail("keypresess failed");
			    	
				
			    }
			
			
			
		
     }

	public void validatetextentered(){
		String [] testkey= {"A","V","D","E"};
		for(int i=0; i<testkey.length;i++) {
				driver.findElement(By.xpath(projectproperties.getProperty("inputKey"))).sendKeys(testkey[i]);
			    String result=driver.findElement(By.xpath(projectproperties.getProperty("result"))).getText();
				String finalresult=null;
			   /* Used split to split the result */
			   
				  String[] arrofresult=result.split(": ");
				   for(String a:arrofresult) {
					  
					   finalresult=a;
				  }
			      try {
			    	  
					Assert.assertEquals(testkey[i], finalresult);
					Thread.sleep(1000);
					driver.findElement(By.xpath(projectproperties.getProperty("inputKey"))).clear();
					System.out.println(" successful::entered text is diplayed ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Assert.fail("text dispalyed after key press is failed");
					e.printStackTrace();
				}
			
		}
	
	
	
	
	}

                
	
	

}
