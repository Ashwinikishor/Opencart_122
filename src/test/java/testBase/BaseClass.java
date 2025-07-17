package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger; //log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
      //Loading config.propertiesfile
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass()); //log4j2
		/*
		//for selenium grid remote execution
		if(p.getProperty("execution_evn").equalsIgnoreCase("remote"))
		{
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//os
		if(os.equalsIgnoreCase("Windows"))
		{
			cap.setPlatform(Platform.WIN10);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			cap.setPlatform(Platform.WIN10);
		}
		else
		{
			System.out.println("No matching os");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" : cap.setBrowserName("chrome");break;
		case "edge" : cap.setBrowserName("MicrosoftEdge");break;
		default: System.out.println("No matching browser"); return;
		}
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		*/
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid broswer name..."); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL1")); //Reading URL from properties file
		driver.manage().window().maximize();
		}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
	driver.quit();	
	}
	
	  public String randomeString()
	   {
		 String generatedstring=RandomStringUtils.randomAlphabetic(5);
		 return generatedstring;
	   }
	   
	   public String randomeNumber()
	   {
		 String generatednumber=RandomStringUtils.randomNumeric(10);
		 return generatednumber;
	   }
	   
	   public String randomeAlphaNumeric()
	   {
		 String generatedstring=RandomStringUtils.randomAlphanumeric(3);
		 String generatednumber=RandomStringUtils.randomNumeric(3);
		 return generatedstring+"@"+generatednumber;
	   }
    
	    public String captureScreen(String tname) {
	    	
	    String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	    TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
	    File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String targetFilePath=System.getProperty("user.dir")+"\\screenshot\\"+tname+" "+timestamp;
	    File targetFile=new File(targetFilePath);
	    	return targetFilePath;
	    }
	    
}
