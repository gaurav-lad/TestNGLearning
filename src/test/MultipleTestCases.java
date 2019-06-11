package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleTestCases {
	public static WebDriver driver;
	static Alert alert;
	public static String url = "file:///C:/Users/Gaurav/Desktop/Selenium/Test.html";
	static String maleRadioButton = "#male";
	static String promptAlertButton = "body > div > div:nth-child(27) > div > p:nth-child(1) > button";
	static String promptReply = "#demoPrompt";

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@Test
	public void verifyRadioButtonChecked() {
		WebElement maleRadioButtonlocation = driver.findElement(By.cssSelector(maleRadioButton));
		Assert.assertTrue(!maleRadioButtonlocation.isSelected());
	}

	@Test
	public static void verifyPromptMessage() {
		WebElement promptAlertButtonLocator = driver.findElement(By.cssSelector(promptAlertButton));
		promptAlertButtonLocator.click();
		alert = driver.switchTo().alert();
		System.out.println("Simple Alert text: " + alert.getText());
		String promptAlertSendKeys = "Gaurav";
		alert.sendKeys(promptAlertSendKeys);
		alert.accept();
		WebElement promptReplyLocator = driver.findElement(By.cssSelector(promptReply));
		String promtAlertReply = promptReplyLocator.getText();
		System.out.println(promtAlertReply);
		Assert.assertEquals(promtAlertReply, "Hello " + promptAlertSendKeys + "! How are you today?");
	}

	@Test
	public static void verifySelectListType() {
		// Select using selectByIndex, selectByValue, SelectByVisisbleText
		WebElement selectList = driver.findElement(By.cssSelector("#testingDropdown"));
		Select select = new Select(selectList);
		select.selectByValue("Database");
		// Check if select list is multi select or not
		System.out.println("Is select list is a multiple or not? " + select.isMultiple());
		Assert.assertEquals(false, select.isMultiple());
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
