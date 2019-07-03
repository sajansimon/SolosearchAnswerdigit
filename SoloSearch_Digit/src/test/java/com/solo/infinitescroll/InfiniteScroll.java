package com.solo.infinitescroll;



import java.io.IOException;



import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

import com.solo.BaseTest.BaseTest;
import com.solo.constatns.SoloProjectConstants;

public class InfiniteScroll extends BaseTest {

	
	
			@Test
				public void test_InfiniteScroll() {
					navigateTo_App();
					 try {
						driver.findElement(By.xpath(projectproperties.getProperty("InfiniteScrollLink"))).click();
						/* test the result page is infinite_scroll */
						 Assert.assertEquals(SoloProjectConstants.expectedInfiniteScrollPageMsg,driver.findElement(By.xpath(projectproperties.getProperty("InfiniteScrollResultPage"))).getText());
						 /* After scroll down the page verify that scroll back to the top of the page  */
						 scrollDownPage();
						 Assert.assertEquals(SoloProjectConstants.expectedInfiniteScrollPageMsg,driver.findElement(By.xpath(projectproperties.getProperty("InfiniteScrollResultPage"))).getText());
					     System.out.println("Successfully completed InfiniteScroll,");
					     } catch (Exception e) {
					    	
						// TODO Auto-generated catch block
					    	 Assert.fail("InfiniteScroll is failed");
					         
					     }
		 
			    }

			 public  void scrollDownPage()throws IOException, InterruptedException
			  {
				  JavascriptExecutor js= (JavascriptExecutor)driver ;
				  	    
				 
				   // This  will scroll down the page to the bottom    		
				       Thread.sleep(1000);
				  	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
			        
			           Thread.sleep(2000);
			           js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
			           //This  will scroll up the page to the top
			           Thread.sleep(1000);
			        // WebElement element = driver.findElement(By.xpath(projectproperties.getProperty("InfiniteScrollResultPage")));
			          WebElement element = driver.findElement(By.tagName("body"));
			           js = (JavascriptExecutor)driver;
			           js.executeScript("arguments[0].scrollIntoView();", element); 
			           Thread.sleep(1000);
			  
			  }

}
