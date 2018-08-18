package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	//WebElement userNameLabel;
	@FindBy(xpath = "//td[contains(text(),'Naveen K')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	//trying something else
	@FindBy(xpath="//*[@id='navmenu']/ul/li[5]/a")//css="#navmenu>li>a[title='deals']" 
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public Boolean verifyDealsLinkDisplayed() {
		return dealsLink.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}
}
