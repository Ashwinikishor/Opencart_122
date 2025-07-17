package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkRepoter; //UI of the report
	public ExtentReports extent; //populating common info on the report
	public ExtentTest test; //creating test case entries in the report and update status of the test method
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date();
		String currentdatetimestamp=df.format(dt);*/
		
		String timestamp=new  SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //timestamp
		
		repName= "Test-Report"+timestamp+".html";
		sparkRepoter=new ExtentSparkReporter(".\\reports\\"+repName); //specify location of the report
		
		sparkRepoter.config().setDocumentTitle("Automation Report"); //Title of report
		sparkRepoter.config().setReportName("Functional Testing"); //Name of the Report
		sparkRepoter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkRepoter);
		
		extent.setSystemInfo("Applicstion", "Opencart");
		extent.setSystemInfo("<Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os= testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);	
				
		String browser= testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test= extent.createTest(result.getTestClass().getName()); //create a new entry in the report
		test.assignCategory(result.getMethod().getGroups()); //to display groups in report
		test.log(Status.PASS, result.getName()+" got successfully executed"); //update status p/f/s
			
	}
	
	public void onTestFailure(ITestResult result)
	{
		test= extent.createTest(result.getTestClass().getName()); 
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+" got failed"); //update status p/f/s
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try{
			String imgPath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		} catch(Exception el)
		{
			el.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test= extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.SKIP, result.getName()+"got skipped"); //update status p/f/s
		test.log(Status.INFO,result.getThrowable().getMessage()); 
			
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
		
		String pathofExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathofExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
