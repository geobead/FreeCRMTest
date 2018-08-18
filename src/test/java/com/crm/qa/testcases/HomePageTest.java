package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	//test cases should be  separate -- independent with each other
	//before each test case, launch the browser and login
	//@test -- execute test case, 10,000, 1,000 doesn't matter
	//after each test case, close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		//page chaining
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title,"CRMPRO","custom error message: Home page title not matched");
	}
	
/*	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
*/	
	@Test(priority=3)
	public void verifyDealsLinkTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyDealsLinkDisplayed());
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
