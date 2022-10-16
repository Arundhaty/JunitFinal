package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
    static String browser;
    static String url;
   
    public static void readconfig() {
    	try {
    		InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
    		Properties prop = new Properties();
    		prop.load(input);
    		browser= prop.getProperty("browser");
    		url = prop.getProperty("url");
    		}catch (IOException e) {
    			e.printStackTrace();
    		}
    }
  
	public static WebDriver init() {
		
		readconfig();
		
    	if (browser.equalsIgnoreCase("chrome")){
    		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
    		driver = new ChromeDriver();
    	}else if(browser.equalsIgnoreCase("Firefox")) {
    		System.setProperty("webdriver.gecko.driver","driver\\geckodriver.exe" );
    	}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get( url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	
	public static void teardown() {
	driver.close();
	driver.quit();
	}
	}
