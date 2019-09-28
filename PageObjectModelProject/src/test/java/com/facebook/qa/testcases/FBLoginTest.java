package com.facebook.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FBHomePage;
import com.facebook.qa.pages.FBLoginPage;


public class FBLoginTest extends TestBase{
	
	@Test
	public void init() throws Exception{

			//driver.get("https://www.facebook.com");
			FBLoginPage loginpage = PageFactory.initElements(driver, FBLoginPage.class);
			loginpage.setEmail("rajkumarsmonline@gmail.com");
			loginpage.setPassword("raj123456");
			loginpage.clickOnLoginButton();
			
			FBHomePage homepage = PageFactory.initElements(driver, FBHomePage.class);
			homepage.clickOnProfileDropdown();
			homepage.verifyLoggedInUserNameText();
			homepage.clickOnLogoutLink();	
		}
	
}