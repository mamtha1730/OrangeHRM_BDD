package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HRMLoginpage extends Basepage
{

	public HRMLoginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement txtusername;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement txtpassword;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnlogin;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement txtsuccess;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement txtinvalidcred;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	private WebElement img_logo;
	
	@FindBy(xpath="//div[@class='orangehrm-login-form']//div[2]//div[1]//span[1]")
	private WebElement pwd_required_tooltip;
	
	@FindBy(xpath="//div[@class=\"orangehrm-login-slot-wrapper\"]//div[1]//div[1]//span[1]")
	private WebElement user_required_tooltip;
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
	private WebElement txt_forgor_pwd;
	
	@FindBy(xpath="//div[@class='orangehrm-login-forgot']//p")
	private WebElement lnk_forgot_pwd;
	
	@FindBy(xpath="//a[text()='OrangeHRM, Inc']")
	private WebElement lnk_url;
	
	@FindBy(xpath="//h1[text()='Peace of mind is just a few clicks away!']")
	private WebElement lnk_verify_url;
	
	
	public void setusername(String user)
	{
		txtusername.sendKeys(user);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}
	
	public String verifyuser()
	{
		String text=txtsuccess.getText();
		return text;
	}
	
	public String verifyinvaliduser()
	{
		String txtfail=txtinvalidcred.getText();
		return txtfail;
	}
	
	public boolean getInputTxtPwd()
	{
		
		String textInsideInputBox = txtpassword.getAttribute("value");

		// Check whether input field is blank
		if(textInsideInputBox.isEmpty())
		{
			return true;
		   //System.out.println("Input field is empty");
		}
		else return false;
	}
	
	public boolean getInputTxtUser()
	{
		
		String textInsideInputBox_user =txtusername.getAttribute("value");

		// Check whether input field is blank
		if(textInsideInputBox_user.isEmpty())
		{
			return true;
		}
		else return false;
	}

	public String getUserToolTipText()
	{
		String User_tool_Tip_text= user_required_tooltip.getText();
		return User_tool_Tip_text;
	}
	
	public String getPwdToolTipText()
	{
		String pwd_tool_Tip_text= pwd_required_tooltip.getText();
		return pwd_tool_Tip_text;
	}
	
//	public void click_hrm_logo()
//	{
//		img_logo.click();
//	}
	public boolean validatelogo()
	{
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(12));
		WebElement logo_bool= mywait.until(ExpectedConditions.visibilityOf(img_logo));
		return(logo_bool.isDisplayed());		
				
	
		//did not work
		//mywait.until(ExpectedConditions.elementSelectionStateToBe(logo_bool, true)
		
	}
	
	public void click_foget_pwd()
	{
		lnk_forgot_pwd.click();
	}
	
	public String verify_forget_pwd()
	{
		String txt_verify_pwd=txt_forgor_pwd.getText();
		return txt_verify_pwd;
	}
	
	public void click_link_url()
	{
		lnk_url.click();
	}
	
	public String verify_link_url()
	{
		String txt_lnk=lnk_verify_url.getText();
		return txt_lnk;
	}
	
}
