package Selenium.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {

	ExtentReports report;
	
	@BeforeTest
	public void extentReport()
	{
		//ExtentSparkReporter , ExtentReports
		
		String path = System.getProperty("user.dir")+"//reports//index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); // to do modifications (config) in the existing html report
		
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setReportName("Web Automation Results");
		
		report = new ExtentReports(); // create test & monitor the execution of it - P OR F
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Jyoti");
	}
	
	@Test
	public void intializeDemo()
	{
		ExtentTest test = report.createTest("Initialize Demo");
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyoti_xfiqe3z\\OneDrive\\Documents\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		
		test.addScreenCaptureFromBase64String("1");
		test.fail("Test do not match expected result");
		
		report.flush();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
