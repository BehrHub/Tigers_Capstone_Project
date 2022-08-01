package core;

import java.io.BufferedReader; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties properties; // This class will help us read data from .properties files
	public static Logger logger; // this class will help us to log each step of our execution
	private String configPath = "./src/test/resources/input/config.properties"; // this is path to config file
	private String log4jPath = "./src/test/resources/input/log4j.properties"; // this is path to log4j file 
	
	public Base() {
	try {
		BufferedReader reader = new BufferedReader(new FileReader(configPath));
		properties = new Properties(); // we create object of Properties class
		properties.load(reader); // we call .load method and pass reader as argument 
		reader.close();// we want to close the reader so the input stream should be closed
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	logger = logger.getLogger(log4jPath);
	PropertyConfigurator.configure(log4jPath); 
		
	}
	
	public static String getUrl() {
		String url = properties.getProperty("url");
		return url; 
	}

	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser; 
	}
	
	public static void launchBrowser() {
		driver.get(getUrl()); 
	}

	public static void tearDown() {
		//driver.close();
		driver.quit();
	}
	
	public void selectBrowser() {
		switch(getBrowser()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "ff":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		default:	
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
}
