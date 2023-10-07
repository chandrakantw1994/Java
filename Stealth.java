package omen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stealth 
{ 
	public static void main(String[] args) 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//ChromeDriver driver = new ChromeDriver(options);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandrakant.W\\eclipse-workspace\\omen\\src\\Driver Servers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://172.16.70.116/login/?redir=index");
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Chandrakant");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tnt1234");
		driver.findElement(By.xpath("//*[@id=\"loginhoder\"]/input")).click();
		
		//Test 1: To verify Application name and version is displayed properly
		
		String title = driver.getTitle();
		String expectedTitle = "VeriShield SM300 v.1.2.10.43";
		
		if(title.equals(expectedTitle))
		{
			System.out.println("1. Application Name & version verified: "+ title);
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Test 2: To verify Dashboard page is displayed properly
		boolean Dashboard = driver.findElement(By.partialLinkText("Dashboard")).isDisplayed();
		if (Dashboard == true)
			System.out.println("Dashboard present");
		
		if(driver.getPageSource().contains("MASTER DATA"))
		{
			System.out.println("Master is present");
		}
		else
		{
			System.out.println("Master is absent");
		}
		
		driver.close();
		

	}

}
