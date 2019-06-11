package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlowOfTestNG {

	/*
	 * @Test: It’s a test case
	 * 
	 * @BeforeTest: will get executed before all the @Test in class
	 * 
	 * @AfterTest: will get executed after all the @Test in class
	 * 
	 * @BeforeMethod: executes before every @Test in class
	 * 
	 * @AfterMethod: executes after every @Test in class
	 * 
	 * @BeforeClass: execute before all/first methods
	 * 
	 * @AfterClass: execute after all/last methods
	 * 
	 * @BeforeSuite: executes before everything i.e. test
	 * 
	 * @AftertSuite: executes after everything i.e. test
	 * 
	 */

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am BEFORE SUITE");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am AFTER SUITE");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am BEFORE CLASS");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am AFTER CLASS");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am BEFORE TEST");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am BEFORE METHOD");
	}

	@Test(priority = 0)
	public void method_c() {
//		WebDriver driver_c = new FirefoxDriver();  //Session ID is generated for driver
//		driver_c.get("https://www.google.com/");
		System.out.println("Method_c");
	}

	@Test(groups = { "smokeTest" }, priority = 0)
	public void method_b() {
//		WebDriver driver_b = new FirefoxDriver();        //Session ID is generated for driver
//		driver_b.get("https://www.stackoverflow.com/");
		System.out.println("Method_b");
	}

	@Test(groups = { "end-to-end" }, invocationCount = 2)
	public void method_a() {
		System.out.println("Method_a");
	}
	
	@Test
	@Parameters({"Name", "LastName"})
	public void method_d(String Name, String LastName) {
		System.out.println("Method_d: " + Name + " " + LastName);
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("I am AFTER METHOD");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am AFTER TEST");
	}

}
