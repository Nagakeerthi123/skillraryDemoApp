package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class FirstTest extends BaseClass
{
	private long time;

	@Test
	public void FirstTest()
	{
		SoftAssert soft =new SoftAssert();
		home.ClickGears();
		home.ClickSkillrarydemoApp();
		web.handleChildBrowser();
		
        soft.assertTrue(skillraryDemo.getPageHeader().isDisplayed());
        
		skillraryDemo.mouseHoverToCourse(web);
		skillraryDemo.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		web.handleAlert();
		web.explicitWait(time, selenium.getItemAddedMessage());
		web.takeScreenshot();
		soft.assertTrue(selenium.getItemAddedMessage().isDisplayed());
		soft.assertAll();
		
		
	}

}
