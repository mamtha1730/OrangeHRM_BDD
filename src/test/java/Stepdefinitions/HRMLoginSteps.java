package Stepdefinitions;

import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.BaseClass;
import Pages.HRMLoginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HRMLoginSteps 
{
	//public WebDriver driver;
	Logger logger;
	HRMLoginpage lp;
	String user_Reqd_Txt, pwd_Reqd_Txt;
	
	@Given("user enters valid username {string}")
	public void user_enters_valid_username(String user)
	{
		BaseClass.getLogger().info("User in HRMLoginpage and enters user name");
		lp= new HRMLoginpage(BaseClass.getDriver());
		lp.setusername(user);
		
	}

	@When("the user enters valid password {string}")
	public void the_user_enters_valid_password(String pwd) 
	{
		BaseClass.getLogger().info("User in HRMLoginpage and enters password.");
		lp= new HRMLoginpage(BaseClass.getDriver());
		lp.setpassword(pwd);
		
	   
	}

	@When("user clicks login button")
	public void user_clicks_login_button()
	{
		BaseClass.getLogger().info("User clicks login button in  HRMLoginpage");
		lp= new HRMLoginpage(BaseClass.getDriver());
		lp.clicklogin();;
		
	   
	}

	@Then("confirm user is successfully logged in")
	public void confirm_user_is_successfully_logged_in() 
	{
		BaseClass.getLogger().info("User in HRMLoginpage to validate success login");
		lp= new HRMLoginpage(BaseClass.getDriver());
		String msg=lp.verifyuser();
		Assert.assertEquals("Dashboard",msg);
		BaseClass.getLogger().info("Succefully logged in!!");
	}
	@Then("validate user is not logged in")
	public void validate_user_is_not_logged_in() 
	{
		BaseClass.getLogger().info("User in HRMLoginpage to validate unsuccessful login");
		lp= new HRMLoginpage(BaseClass.getDriver());
		String msg2=lp.verifyinvaliduser();
		Assert.assertEquals("Invalid credentials",msg2);
		BaseClass.getLogger().info("Unsuccessful login -Try again");
	}

	@Then("validate user with corresponding tooltip message")
	public void validate_user_with_corresponding_tooltip_message() throws InterruptedException
	{
     	lp= new HRMLoginpage(BaseClass.getDriver());
     	SoftAssertions sa = new SoftAssertions();
        boolean tooltip_pwd_text= lp.getInputTxtPwd();
        boolean tooltip_user_text=lp.getInputTxtUser();
       
        //validate User field is empty
        if(tooltip_user_text )
        {
          	user_Reqd_Txt= lp.getUserToolTipText();
          	System.out.println("UserName Required text: "+user_Reqd_Txt);
          	Assert.assertEquals("Required",user_Reqd_Txt);
        }
        if(tooltip_pwd_text)
        {
        	pwd_Reqd_Txt= lp.getPwdToolTipText();
          	System.out.println("Password Required text: "+pwd_Reqd_Txt);
          	Assert.assertEquals("Required",pwd_Reqd_Txt);
        }
        if ((tooltip_user_text) && (tooltip_pwd_text) )
        {
        	System.out.println("UserName Required text: "+user_Reqd_Txt);
        	System.out.println("Password Required text: "+pwd_Reqd_Txt);
        	Assert.assertEquals("Required",user_Reqd_Txt,pwd_Reqd_Txt);
        }
	 sa.assertAll();
	}

	
	@Given("user clicks hrmlogo")
	public void user_clicks_hrmlogo()
	{
		lp= new HRMLoginpage(BaseClass.getDriver());
		//lp.click_hrm_logo();
	   
	}
	@Then("user validates HRMlogo")
	public void user_validates_hr_mlogo() 
	{
		
	 lp= new HRMLoginpage(BaseClass.getDriver());
		boolean bool_logo=lp.validatelogo();
		System.out.println("bool message: "+bool_logo);
		Assert.assertEquals(bool_logo,true);
	}
	
	@Given("user clicks forget password link")
	public void user_clicks_forget_password_link() 
	{
		lp= new HRMLoginpage(BaseClass.getDriver());
		lp.click_foget_pwd();
	}
	@Then("user  validates forget password link")
	public void user_validates_forget_password_link() 
	{
		lp= new HRMLoginpage(BaseClass.getDriver());
		String txt_password_link=lp.verify_forget_pwd();
		//System.out.println("Link -password-verify: "+txt_password_link);
		Assert.assertEquals("Reset Password",txt_password_link);
	}
	@Given("user clicks hrm_url_link")
	public void user_clicks_hrm_url_link() throws InterruptedException
	{
		lp= new HRMLoginpage(BaseClass.getDriver());
		lp.click_link_url();
		
	}
	@Then("user validates hrm_url_link")
	public void user_validates_hrm_url_link() throws InterruptedException  
	{
		lp= new HRMLoginpage(BaseClass.getDriver());
		List<String> winid=new ArrayList(BaseClass.getDriver().getWindowHandles());
		BaseClass.getDriver().switchTo().window(winid.get(1));
		Thread.sleep(2000);
		
		String text_lnk=lp.verify_link_url();
		Assert.assertEquals("Peace of mind is just a few clicks away!",text_lnk);
	}



	}






