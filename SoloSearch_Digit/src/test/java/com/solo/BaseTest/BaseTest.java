/***
 * @author sajan
 * BaseTest.java 
 * developed and designed for all classes
 */

package com.solo.BaseTest;
import com.solo.utility.Log;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.JavascriptExecutor;


import com.solo.constatns.SoloProjectConstants;




public class BaseTest {

	protected   WebDriver driver=null;
	protected  static Properties projectproperties=null;
	protected  static FileInputStream fis=null;
	  
    public int browserType=3;

	
	@Before
	public void beforeAll() throws Exception {
		
		Log.startTestCase(this.getClass().getSimpleName());
		System.out.println("this.getClass().getSimpleName()"+this.getClass().getSimpleName());
		initConfig();
		initDriver();
		
			     
	}
	
	@After
	public void afterAll() throws Exception{
		
     	Log.info("closing all ");	
		driver.close();
		
	}

	
	public void initConfig()  {
		
	    Log.info("initializing config");	
			try {
				     fis=new FileInputStream(SoloProjectConstants.solopropertyfile);
			    	 projectproperties=new Properties();
				     projectproperties.load(fis);
			    } catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			    }
	
	}
    public void initDriver()
    {
	   Log.info("initializing driver");
	   
	    String browser=null;
	     if(driver==null) {
	    	     	switch(browserType) {
								    	case 1:  browser="firefox";
										    	 System.setProperty("webdriver.gecko.driver", projectproperties.getProperty("driverpath")+"geckodriver.exe");
									  		     DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
									  			 capabilities1.setCapability("marionette", true);
									  			 driver=new FirefoxDriver(capabilities1);
										    	  break;
								    		
								    	case 2:  browser="IE"; 
										    	 System.setProperty("webdriver.ie.driver", projectproperties.getProperty("driverpath")+"IEDriverServer.exe");
												 DesiredCapabilities  capabilities2= DesiredCapabilities.internetExplorer();
												 capabilities2.setCapability("ignorZoomSetting", true);
												 driver=new InternetExplorerDriver(capabilities2);
								    		     break;
								    		
								    	case 3:  browser="Chrome";    		
								    			 System.setProperty("webdriver.chrome.driver",  projectproperties.getProperty("driverpath")+"chromedriver.exe");
											     DesiredCapabilities capabilities3 = DesiredCapabilities.chrome();
											     capabilities3.setBrowserName("chrome");
											     driver=new ChromeDriver(); 
								    		     break;
								    		
								    		
								    	case 4:  browser="edge";
								    		     System.setProperty("webdriver.edge.driver",  projectproperties.getProperty("driverpath")+"MicrosoftWebDriver.exe");
											     DesiredCapabilities capabilities4 = DesiredCapabilities.chrome();
											     capabilities4.setBrowserName("edge");
												 driver=new EdgeDriver();
								    		     break;
								    	
			    	}
				    	      
		   
	       }//end of checking driver 
	   
   }
    
    
    public void navigateTo_App() {
 	   
		// TODO Auto-generated method stub
	   try {
		   Log.info("navigating to URL");
		   pageImplicitWait();		  
		   driver.navigate().to(projectproperties.getProperty("testURL"));
		   pageLoadTime();
		 
	       } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	       }
	}
     
   public void navigationTo_BasicAuth() {
	   
		// TODO Auto-generated method stub
	   try {
		   Log.info("Basic_auth starts from here");
		   pageImplicitWait();		  
		   pageLoadTime();
		 
	       } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	       }
	}
     
   
   /*
       *pageLoadTime()
       *set  time for loading page   
     
     **/
   
 
   
   
    public void pageLoadTime() {
	// TODO Auto-generated method stub
	driver.manage().timeouts().pageLoadTimeout(SoloProjectConstants.pageLoadingTime, TimeUnit.SECONDS);
    }

    
public void pageImplicitWait() {
	
	driver.manage().timeouts().implicitlyWait(SoloProjectConstants.implictwaitingTime, TimeUnit.SECONDS);
}
	


}
