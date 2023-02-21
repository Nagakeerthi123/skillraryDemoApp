package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.CoreJavaForSelenium;
import pompages.CoreJavaVideoPage;
import pompages.HomePagePom;
import pompages.SeleniumTrainingPage;
import pompages.SkillraryDemoAppPagePom;
import pompages.TestingPage;

public class BaseClass 
{
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePagePom home;
	protected SkillraryDemoAppPagePom skillraryDemo;
	protected ContactUsPage contact;
	protected TestingPage testing;
	protected CoreJavaForSelenium coreJava;
	protected SeleniumTrainingPage selenium;
	protected CoreJavaVideoPage javaVideo;
	protected long time;
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	       public void classConfiguration()
	       {
		     PropertiesFileUtility property= new PropertiesFileUtility();
		     ExcelUtility excel= new ExcelUtility();
		     @SuppressWarnings("unused")
			 WebDriverUtility web= new WebDriverUtility();
		
		     
		     property.propertyFileInitialization(IConstantpath .PROPERTIES_FILE_PATH);
		     excel.excelInitialization(IConstantpath.EXCEL_FILE_PATH);
		     
	       }

	@BeforeMethod
	public void methodConfiguration() {
	 time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);
		home=new HomePagePom(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		skillraryDemo = new SkillraryDemoAppPagePom(driver);
		selenium= new SeleniumTrainingPage(driver);
		coreJava=new CoreJavaForSelenium(driver);
		javaVideo=new CoreJavaVideoPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
	}

	@AfterMethod
	    public void methodTearDown()
	    {
		   web.quitBrowser();
	    }
	@AfterClass
	     public void classTearDown()
	     {
		   excel.closeExcel();
	     }
       	
	// @AfterTest
	// @AfterSuite

}
